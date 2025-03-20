public class helloworld {
    public static void main(String[] args) {
        printConversion(0.0d);
    }
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            return Math.round(kilometersPerHour / 1.609);
        }
    }


    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " Km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
        }
    }
}
