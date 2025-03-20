package Inheritance;

public class Car implements Engine, Brake, Media{
    @Override
    public void brake() {
        System.out.println("Apply brake as you are over speeding");
    }

    @Override
    public void start() {
        System.out.println("car is started");
    }

    @Override
    public void stop() {
        System.out.println("car is stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("car accelerating at the speed of 120km/h");
    }
}
