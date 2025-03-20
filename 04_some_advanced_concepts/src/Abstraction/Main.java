package Abstraction;

public class Main {
    public static void main(String[] args) {
        Son son1 = new Son(33);
        son1.career("chef");
        son1.partner();

        System.out.println("--------------------------------------");

        Daughter daughter = new Daughter(23);
        daughter.career("interior designer");
        daughter.normal();

        System.out.println("--------------------------------------");
        Parent.staticMethod();

    }
}