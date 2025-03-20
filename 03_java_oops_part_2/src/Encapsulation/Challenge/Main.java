package Encapsulation.Challenge;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(1, false);

        System.out.println(printer);
        System.out.println(printer.addToner(5));
    }
}
