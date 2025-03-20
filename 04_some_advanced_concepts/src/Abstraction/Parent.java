package Abstraction;

public abstract class Parent {
    int age;
    public Parent(int age) {
        this.age = age;
    }

    abstract void career(String name);
    abstract void partner();


//    static method in abstract class
    static void staticMethod(){
        System.out.println("I am a static method in abstract class");
    }
    void normal(){
        System.out.println("I am a normal method");
    }

}
