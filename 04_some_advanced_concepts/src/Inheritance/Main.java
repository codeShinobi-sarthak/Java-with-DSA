package Inheritance;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.start();
        car.accelerate();
        car.brake();
        car.stop();


//        System.out.println("-----------------------------------------------------------");
//        Inheritance.Brake audi = new Inheritance.Car();
//        Inheritance.Engine honda = new Inheritance.Car();
//
//        honda.start();
//        honda.accelerate();
//        audi.brake();
//        honda.stop();

        System.out.println("-----------------------------------------------------------");

//        ! there is error in this code while executing
        Media myMedia = new Car();
        System.out.print("error is media is stating the engine :  ");
        myMedia.start();

        System.out.println("-----------------------------------------------------------");

        NewCar newCar = new NewCar();
        newCar.start();
        newCar.startMusic();
        newCar.stopMusic();

        System.out.println("-----------------------------------------------------------");
    }
}