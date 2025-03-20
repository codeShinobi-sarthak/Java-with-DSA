package inheritance;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("animal", 400);
        doAnimalStuff(animal, "slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog hop = new Dog("german", 40);
        doAnimalStuff(hop, "fast");

        Fish nemo = new Fish("fish", 5,2, 1);
        System.out.println(nemo);
    }

    public static void doAnimalStuff(Animal animal, String speed){
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("-------------------");
    }
}
