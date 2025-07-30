package EmployeePayrollManagementSystem;

public class FullTimeEmployee extends Employee{
    private double baseSalary;
    private double hoursWorked;
    private static final double STANDARD_HOURS = 40.0;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    public FullTimeEmployee(String name, String employeeId, double baseSalary, double hoursWorked) {
        super(name, employeeId, EmployeeType.FULL_TIME);
        this.baseSalary = baseSalary;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        double totalSalary = getBaseSalary();
        if (getHoursWorked() > STANDARD_HOURS) {
            totalSalary += getOvertimePay();
        }
        return totalSalary;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public double getOvertimeHours() {
        return Math.max(0, getHoursWorked() - STANDARD_HOURS);
    }
    public double getOvertimePay() {
        if (getHoursWorked() <= STANDARD_HOURS) return 0;

        double overtimeHours = getHoursWorked() - STANDARD_HOURS;
        double hourlyRate = getBaseSalary() / (STANDARD_HOURS * 5);
        return overtimeHours * hourlyRate * OVERTIME_MULTIPLIER;
    }
    public double getHourlyRate() {
        return getBaseSalary() / (STANDARD_HOURS * 5);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append(String.format("Base Salary: $%.2f\n", getBaseSalary()));

        if (getOvertimeHours() > 0) {
            sb.append(String.format("Overtime Pay: $%.2f (%.0f hours at $%.2f/hour)\n",
                    getOvertimePay(), getOvertimeHours(), getHourlyRate() * OVERTIME_MULTIPLIER));
        }
        sb.append(String.format("Total Salary: $%.2f", calculateSalary()));
        return sb.toString();
    }
}
