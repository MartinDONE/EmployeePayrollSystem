package EmployeePayrollManagementSystem;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public PartTimeEmployee(String name, String employeeId, double hourlyRate, double hoursWorked) {
        super(name, employeeId, EmployeeType.PART_TIME);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return getHourlyRate() * getHoursWorked();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append(String.format("Hours Worked: %.0f\n", getHoursWorked()));
        sb.append(String.format("Hourly Rate: $%.2f\n", getHourlyRate()));
        sb.append(String.format("Total Salary: $%.2f", calculateSalary()));
        return sb.toString();
    }
}
