public class Burger {
    private  String burgerType;
    private  double burgerPrice;

    public Burger() {
        this("Mc aloo", 50);
    }

    public Burger(String burgerType, double burgerPrice) {
        this.burgerType = burgerType;
        this.burgerPrice = burgerPrice;
    }

    public String getBurgerType() {
        return burgerType;
    }

    public double getBurgerPrice() {
        return burgerPrice;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "burgerType='" + burgerType + '\'' +
                ", burgerPrice=" + burgerPrice +
                '}';
    }
}

class HamBurger extends Burger {
    public HamBurger() {
        super("ham burger", 100);
    }
}

class VeggiBurger extends Burger {
    public VeggiBurger() {
        super("veggi burger", 67);
    }
}

class PaneerBurger extends Burger {
    public PaneerBurger() {
        super("paneer burger", 156);
    }
}
