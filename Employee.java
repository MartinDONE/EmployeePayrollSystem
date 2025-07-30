package EmployeePayrollManagementSystem;

public abstract class Employee implements PayrollCalculator{
    protected String name;
    protected String employeeId;
    protected EmployeeType type;
    public Employee(String name, String employeeId, EmployeeType type) {
        this.name = name;
        this.employeeId = employeeId;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public EmployeeType getType() {
        return type;
    }
    public abstract double calculateSalary();
    @Override
    public double calculatePayroll() {
        return calculateSalary();
    }
    @Override
    public String toString() {
        return String.format("Employee: %s (%s) - %s",
                name, employeeId, type.getDisplayName());
    }

}
