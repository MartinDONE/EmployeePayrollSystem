package EmployeePayrollManagementSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        payrollSystem.addEmployee(new FullTimeEmployee("John Smith", "FT001", 5000, 45));
        payrollSystem.addEmployee(new PartTimeEmployee("Jane Doe", "PT002", 25, 30));
        payrollSystem.addEmployee(new ContractEmployee("Bob Wilson", "CT003", 12000, 6));

        payrollSystem.generatePayrollReport();
    }
}
