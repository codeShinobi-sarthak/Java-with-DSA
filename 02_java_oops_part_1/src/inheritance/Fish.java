package inheritance;

public class Fish extends Animal {
    private int gills;
    private int fins;

    public Fish(int gills, int fins) {
        this.gills = gills;
        this.fins = fins;
    }

    public Fish(String type, double weight, int gills, int fins) {
        super(type, weight);
        this.gills = gills;
        this.fins = fins;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }
}
