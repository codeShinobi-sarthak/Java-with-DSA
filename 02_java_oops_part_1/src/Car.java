//for practice

public class Car {
    private String name = "Range rover";
    private String model = "model X";
    private String color = "black";
    private int doors = 2;
    private boolean convertible = true;

    public String getModel() {
        return model;
    }

//    getter methods
    public String getName() {
        return name;
    }

    public int getDoors() {
        return doors;
    }

    public String getColor() {
        return color;
    }

    public boolean isConvertible() {
        return convertible;
    }

//    setter methods
    public void setName(String name){
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public void describeCar(){
        System.out.println(name + ", " + model + ", " + color + ", " + doors + ", " + convertible);
    }
}
