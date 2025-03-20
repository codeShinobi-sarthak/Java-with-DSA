import java.util.Scanner;

public class Sides {
    private final String type;
    private String size;
    private double price;

    public Sides() {
        this("fries", "M", 34);
    }

    public Sides(String type, String size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public Sides(String type) {
        this.type = type;
        this.size = setSize();
        this.price = setPrice(0);
    }

    public String setSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select your Sides size (S: small, M: medium, L: large): ");

        String sideSize = scanner.nextLine().toUpperCase();
        switch (sideSize) {
            case "S":
                return this.size = "small";
            case "M":
                return this.size = "medium";
            case "L":
                return this.size = "large";
        }
        ;
        return "medium";
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        return this.price = price;
    }

    @Override
    public String toString() {
        return "Sides{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}

    class Fries extends Sides {

        private double price;

        public Fries() {
            super("fries");
            this.price = setPrice();
        }

        public double setPrice() {
            if (super.getSize() == "small") {
                return super.setPrice(30);
            } else if (super.getSize() == "medium") {
                return super.setPrice(50);
            } else if (super.getSize() == "large") {
                return super.setPrice(60);
            }
            return 0.0;
        }
    }

    class Nuggets extends Sides {

        private double price;

        public Nuggets() {
            super("Nuggets");
            this.price = setPrice();
        }

        public double setPrice() {
            if (super.getSize() == "small") {
                return super.setPrice(80);
            } else if (super.getSize() == "medium") {
                return super.setPrice(100);
            } else if (super.getSize() == "large") {
                return super.setPrice(120);
            }
            return 0.0;
        }
    }

    class Salad extends Sides {

        private double price;

        public Salad() {
            super("Salad");
            this.price = setPrice();
        }

        public double setPrice() {
            if (super.getSize() == "small") {
                return super.setPrice(100);
            } else if (super.getSize() == "medium") {
                return super.setPrice(150);
            } else if (super.getSize() == "large") {
                return super.setPrice(180);
            }
            return 0.0;
        }
    }
