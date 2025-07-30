Exercise: Employee Payroll Management System
Problem: Create a Java program that manages employee payroll with different 
employee types and salary calculations.
Requirements:

Create an abstract Employee class with common fields (name, ID, base salary)
Create concrete classes: FullTimeEmployee, PartTimeEmployee, and ContractEmployee
Implement an interface PayrollCalculator for salary calculations
Create a PayrollSystem class to manage all employees
Each employee type calculates salary differently:

FullTime: Base salary + overtime pay (1.5x hourly rate for hours > 40)
PartTime: Hourly rate × hours worked
Contract: Fixed project amount ÷ number of months



Input Example:
Employees to add:
1. FullTime: "John Smith", ID: "FT001", Base: $5000, Hours worked: 45
2. PartTime: "Jane Doe", ID: "PT002", Hourly rate: $25, Hours: 30
3. Contract: "Bob Wilson", ID: "CT003", Project amount: $12000, Duration: 6 months

Operations:
1. Calculate payroll for all employees
2. Find highest paid employee
3. Display employees by type
4. Calculate total payroll cost
Expected Output:
=== Employee Payroll System ===

Monthly Payroll Report:
Employee: John Smith (FT001) - Full Time
Base Salary: $5000.00
Overtime Pay: $187.50 (5 hours at $37.50/hour)
Total Salary: $5187.50

Employee: Jane Doe (PT002) - Part Time
Hours Worked: 30
Hourly Rate: $25.00
Total Salary: $750.00

Employee: Bob Wilson (CT003) - Contract
Project Amount: $12000.00
Monthly Payment: $2000.00

=== Summary ===
Highest Paid Employee: John Smith - $5187.50
Total Payroll Cost: $7937.50

Employees by Type:
Full Time (1): John Smith
Part Time (1): Jane Doe
Contract (1): Bob Wilson
Focus Areas:

Abstract classes and inheritance
Interface implementation
Polymorphism (different salary calculations)
Collections management
Enum usage (for employee types)
Method overriding
Calculations with precision (BigDecimal recommended)

Bonus Challenge: Add a method to generate a payroll report that can be 
exported to a formatted string (like a CSV format)
This exercise combines inheritance, polymorphism, interfaces, 
and business logic calculations - perfect Level 3 complexity with 
real-world application! Take your time with the different employee 
types and their unique calculation methods.




