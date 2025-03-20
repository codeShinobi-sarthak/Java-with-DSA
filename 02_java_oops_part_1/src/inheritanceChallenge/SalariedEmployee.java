package inheritanceChallenge;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, long employeeId, String hireDate, double annualSalary) {
        super(name, birthDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double collectPay() {
        return annualSalary/2;
    }

    public boolean retire(){
        endDate = "08/02/2024";
        return isRetired = true;
    }
}
