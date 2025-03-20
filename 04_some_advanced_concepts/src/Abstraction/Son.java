package Abstraction;

public class Son extends Parent {

    public Son(int age) {
        super(age);
    }

    @Override
    void career(String name) {
        System.out.println("I want to become a " + name);
    }

    @Override
    void partner() {
        System.out.println("I want a dog as a partner not a human, absolutely I don't want to marry it just my bestie partner");
    }
}
