package EmployeePayrollManagementSystem;

public class ContractEmployee extends Employee {
    private double projectAmount;
    private int contractMonths;

    public ContractEmployee(String name, String employeeId, double projectAmount, int contractMonths) {
        super(name, employeeId, EmployeeType.CONTRACT);
        this.projectAmount = projectAmount;
        this.contractMonths = contractMonths;
    }

    @Override
    public double calculateSalary() {
        return getProjectAmount() / getContractMonths();
    }
    public double getProjectAmount() {
        return projectAmount;
    }
    public int getContractMonths() {
        return contractMonths;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append(String.format("Project Amount: $%.2f\n", getProjectAmount()));
        sb.append(String.format("Monthly Payment: $%.2f", calculateSalary()));
        return sb.toString();
    }
}
