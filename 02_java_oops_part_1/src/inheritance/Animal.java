package inheritance;

public class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal() {
        System.out.println("constructor called with no args");
    }

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public Animal(String type, double weight) {
        this.type = type;
        this.size = "default";
        this.weight = weight;
        System.out.println("constructor called with args");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void move(String speed){
        System.out.println(type + " moves " + speed);
    }

    public void  makeNoise(){
        System.out.println(type + " make some noise ");
    }
}
