import java.util.Scanner;

public class MealOrder {
    private Burger burger;
    private Drink drink;
    private Sides sides;

    public MealOrder() {
        this.burger = new Burger();
        this.drink = new Drink();
        this.sides = new Sides();
    }

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Sides getSides() {
        return sides;
    }

    public void setSides(Sides sides) {
        this.sides = sides;
    }


    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Meal Order System! lets take your order");

        // Getting user input for burger
        System.out.println("""
                Select your burger type 
                [1: HamBurger, 
                2: VeggiBurger, 
                3: PaneerBurger, 
                0: Default] : """);
        int burgerChoice = scanner.nextInt();

        switch (burgerChoice) {
            case 1:
                this.setBurger(new HamBurger());
                break;
            case 2:
                this.setBurger(new VeggiBurger());
                break;
            case 3:
                this.setBurger(new PaneerBurger());
                break;
            default:
                System.out.println("Invalid choice. Default burger chosen.");
                this.setBurger(new Burger());
        }

        // Getting user input for drink
        System.out.println("""
                Select your drink 
                [1: Coke,
                 2: Pepsi,
                 3: Fanta,
                 4: Limca,
                 0: default drink] : """);
        int drinkChoice = scanner.nextInt();

        switch (drinkChoice) {
            case 1:
                this.setDrink(new Coke());
                break;
            case 2:
                this.setDrink(new Pepsi());
                break;
            case 3:
                this.setDrink(new Fanta());
                break;
            case 4:
                this.setDrink(new Limca());
                break;
            default:
                System.out.println("Invalid choice. No drink selected.");
                this.setDrink(new Drink());
        }

        // Getting user input for sides
        System.out.println("""
                Select your sides 
                [1: Fries, 
                2: Nuggets, 
                3: Salad, 
                0: default drink] : """);
        int sidesChoice = scanner.nextInt();

        switch (sidesChoice) {
            case 1:
                this.setSides(new Fries());
                break;
            case 2:
                this.setSides(new Nuggets());
                break;
            case 3:
                this.setSides(new Salad());
                break;
            default:
                System.out.println("Invalid choice. No drink selected.");
                this.setSides(new Sides());
        }

        System.out.println("---- Your order is confirmed ---- \n");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "your order reciept:- \n" +
                burger + " : " + getBurger().getBurgerPrice() + "\n" +
                drink + " : " + getDrink().getDrinkPrice() + "\n" +
                sides + " : " + getSides().getPrice() + "\n" +
                "\nyour total amount will be : " + (getBurger().getBurgerPrice() + getDrink().getDrinkPrice() + getSides().getPrice()) +
                '}';
    }
}