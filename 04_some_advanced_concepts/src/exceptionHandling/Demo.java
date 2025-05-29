package exceptionHandling;

public class Demo {
    public static void main(String[] args) {
        System.out.println(Main.divide(20, 4)); // does not throw error
        System.out.println(Main.divide(20, 0)); // does throw error
        System.out.println(Main.divide(0, 4)); // does not throw error
    }
}
