package EmployeePayrollManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PayrollSystem {

    private List<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void removeEmployee(String employeeId) {
        employees.removeIf(emp -> emp.getEmployeeId().equals(employeeId));
    }
    public void generatePayrollReport() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }

        System.out.println("=== Employee Payroll System ===\n");
        System.out.println("Monthly Payroll Report:");
        for (Employee employee : getEmployees()) {
            System.out.println(employee+"\n");
        }

        System.out.println("=== Summary ===");
        Employee highestPaid = getEmployees().stream()
                .max((e1, e2) -> Double.compare(e1.calculateSalary(), e2.calculateSalary()))
                .orElse(null);
        if (highestPaid != null) {
            System.out.printf("Highest Paid Employee: %s - $%.2f\n",
                    highestPaid.getName(), highestPaid.calculateSalary());
        }

        double totalCost = getEmployees().stream()
                .mapToDouble(Employee::calculateSalary)
                .sum();
        System.out.printf("Total Payroll Cost: $%.2f\n\n", totalCost);

        displayEmployeesByType();

        System.out.println("\n=== CSV Export ===");
        System.out.println(generateCSVReport());
    }

    private void displayEmployeesByType() {
        System.out.println("Employees by Type:");
        Map<EmployeeType, List<Employee>> employeesByType = getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getType));

        for (EmployeeType type : EmployeeType.values()) {
            List<Employee> typeEmployees = employeesByType.getOrDefault(type, new ArrayList<>());
            if (!typeEmployees.isEmpty()) {
                String employeeNames = typeEmployees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.joining(", "));
                System.out.printf("%s (%d): %s\n",
                        type.getDisplayName(), typeEmployees.size(), employeeNames);
            }
        }
    }
    public String generateCSVReport() {
        StringBuilder csv = new StringBuilder();
        csv.append("Name,ID,Type,Salary\n");

        for (Employee employee : getEmployees()) {
            csv.append(String.format("%s,%s,%s,%.2f\n",
                    employee.getName(),
                    employee.getEmployeeId(),
                    employee.getType().getDisplayName(),
                    employee.calculateSalary()));
        }
        return csv.toString();
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}
