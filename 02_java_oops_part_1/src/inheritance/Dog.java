package inheritance;

public class Dog extends Animal {
    private String earShape;
    private String tailShape;

    public Dog(String type, double weight){
        this(type, weight, "round", "curly");
    }
    public Dog(){
        super("dog", "dog size", 30);
        System.out.println("dog constructor is called");
    }



    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type,
                weight < 15 ? "child" : "adult", weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    public void makeNoise(){
        bark();
        System.out.println("makeNoise override in dog class");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        System.out.println("override the move method with some additional feature and from  animal class also");
//        here protected keyword is used in animal class for type to access
        if (type == "german"){
            jump();;
            shakeHands();
        }else jump();
    }

    private void bark(){
        System.out.println("dog bark!");
    }

    private void jump(){
        System.out.println("dog jump");
    }

    private void shakeHands(){
        System.out.println("dog shakes hands");
    }
}
