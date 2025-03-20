package inheritanceChallenge;

public class Main {
    public static void main(String[] args) {
        Employee sam = new Employee("sam", "11/11/2000", 52455, "01/01/2021");

        System.out.println(sam);
        System.out.println("age = " + sam.getAge());
        System.out.println("pay = " + sam.collectPay());

        SalariedEmployee tom = new SalariedEmployee("tom", "12/5/1997", 454454, "20/6/2020", 500000);

        System.out.println("\n" +tom);
        System.out.println("collect pay = " + tom.collectPay());
        System.out.println("retire = " + tom.retire());
        System.out.println(tom);

        HourlyEmployee ram = new HourlyEmployee("ram", "12/5/1985", 145545, "1/11/2020", 500,9);

        System.out.println("\n" + ram);
        System.out.println("collect pay = " + ram.collectPay());
        System.out.println("double pay = " + ram.getDoublePay());
    }
}
