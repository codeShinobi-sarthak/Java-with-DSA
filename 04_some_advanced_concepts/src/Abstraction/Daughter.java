package Abstraction;

public class Daughter extends Parent {

    public Daughter(int age) {
        super(age);
    }

    @Override
    void career(String name) {
        System.out.println("i want to become a " + name);
    }

    @Override
    void partner() {
        System.out.println("i am a moody");
    }

}
