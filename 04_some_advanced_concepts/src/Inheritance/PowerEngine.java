package Inheritance;

public class PowerEngine implements Engine{
    public void start() {
        System.out.println("this is an power engine, started ");
    }

    @Override
    public void stop() {
        System.out.println("power engine stops");
    }

    @Override
    public void accelerate() {
        System.out.println("power engine accelerate");
    }
}
