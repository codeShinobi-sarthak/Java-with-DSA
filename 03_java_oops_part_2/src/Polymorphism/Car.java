package Polymorphism;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    //    public car(String description) {
//        if (description == "Polymorphism.GasPoweredCar"){
//            Polymorphism.GasPoweredCar gasPoweredCar = new Polymorphism.GasPoweredCar();
//        } else if (description == "Polymorphism.ElectricCar") {
//            Polymorphism.ElectricCar electricCar = new Polymorphism.ElectricCar();
//        } else if (description == "Polymorphism.HybridCar"){
//            Polymorphism.HybridCar hybridCar = new Polymorphism.HybridCar();
//        } else {
//            System.out.println("invalid description");
//        }
//        this.description = description;
//    }

    public void startEngine(){
        System.out.println("engine just start");
        runEngine();
    }

    public void drive(){
        System.out.println("lets drive the car of type: " + getClass().getSimpleName());
    }

    protected void runEngine(){
        System.out.println("engine is now running !");
    }
}

class GasPoweredCar extends Car{
    private double avg;
    private int cylinders;

    public GasPoweredCar(String description, double avg, int cylinders) {
        super(description);
        this.avg = avg;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.printf("%d cylinders are powered up \n", cylinders);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("driving at an avg speed of " + avg);
    }
}

class ElectricCar extends Car{
    private double avg;
    private int batterySize;

    public ElectricCar(String description) {
        super(description);
    }

    public void startEngine() {
        super.startEngine();
        System.out.printf("its batter size is %d\n", batterySize);
    }

    @Override
    public void drive() {
        System.out.println("driving at an avg speed of \n" + avg);
    }
}


class HybridCar extends Car{
    private double avg;
    private int cylinders;
    private int batterySize;

    public HybridCar(String description) {
        super(description);
    }

    public void drive() {
        System.out.println("driving at an avg speed of" + avg);
    }
}

