package Polymorphism;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("honda city");
        run(car);

        Car ferrari = new GasPoweredCar("its a ferrari", 12, 6);
        run(ferrari);
    }

    public static void run(Car car){
        car.startEngine();
        car.drive();
        System.out.printf("\n");
    }
}