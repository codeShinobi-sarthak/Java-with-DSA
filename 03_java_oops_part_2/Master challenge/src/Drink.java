import java.util.Scanner;

public class Drink{
    private String drinkType;
    private String drinkSize;
    private double drinkPrice;

    public Drink() {
        this("Coke", "M", 50);
    }

    public Drink(String drinkType, String drinkSize, double drinkPrice) {
        this.drinkType = drinkType;
        this.drinkSize = drinkSize;
        this.drinkPrice = drinkPrice;
    }

    public Drink(String drinkType) {
        this.drinkType = drinkType;
        this.drinkSize = setDrinkSize();
        this.drinkPrice = setDrinkPrice();
    }

    public String setDrinkSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select your drink size (S: small, M: medium, L: large): ");

        String drinkSize = scanner.nextLine().toUpperCase();
        switch(drinkSize){
            case "S": return this.drinkSize = "small";
            case "M": return this.drinkSize = "medium";
            case "L": return this.drinkSize = "large";
        };
        return "medium";
    }

    public double setDrinkPrice() {
        if (this.drinkSize == "small"){
            return this.drinkPrice = 30;
        } else if (this.drinkSize == "medium") {
            return this.drinkPrice = 50;
        } else if (this.drinkSize == "large"){
            return this.drinkPrice = 60;
        }
        return 0;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkType='" + drinkType + '\'' +
                ", drinkSize='" + drinkSize + '\'' +
                ", drinkPrice=" + drinkPrice +
                '}';
    }
}

class Pepsi extends Drink{
    public Pepsi() {
        super("Pepesi");
    }
}

class Fanta extends Drink{
    public Fanta() {
        super("fanta");}
}

class Coke extends Drink{
    public Coke() {
        super("Coke");
    }
}
class Limca extends Drink{
    public Limca() {
        super("limca");
    }
}
