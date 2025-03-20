package inheritanceChallenge;

public class HourlyEmployee extends Employee {
    private double hourlyPayRate;

    private int hoursWorked;

    public HourlyEmployee(String name, String birthDate, long employeeId, String hireDate, double hourlyPayRate, int hoursWorked) {
        super(name, birthDate, employeeId, hireDate);
        this.hourlyPayRate = hourlyPayRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double collectPay() {
        return hoursWorked*hourlyPayRate;
    }

    public double getDoublePay(){
        return collectPay()*2;
    }
}
