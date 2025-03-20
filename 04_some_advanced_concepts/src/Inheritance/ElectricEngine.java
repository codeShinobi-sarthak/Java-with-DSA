package Inheritance;

public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("this is an electric engine, started ");
    }

    @Override
    public void stop() {
        System.out.println("electric engine stops");
    }

    @Override
    public void accelerate() {
        System.out.println("electric engine accelerate");
    }
}
