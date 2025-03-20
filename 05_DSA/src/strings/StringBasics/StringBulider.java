package StringBasics;

public class StringBulider {
    public static void main(String[] args) {

        String helloWorld = "hello " + "world";
        StringBuilder helloWorldBuilder = new StringBuilder(("hello " + "world"));

        helloWorld.concat("how are you");
        helloWorldBuilder.append(" how are you");

        printInfo(helloWorld);
        printInfo(helloWorldBuilder);

        StringBuilder emptyStart = new StringBuilder();
//        emptyStart.append("a".repeat(17));
        StringBuilder emptyStart32 = new StringBuilder(32);
//        emptyStart32.append("a".repeat(17));

        printInfo(emptyStart);
        printInfo(emptyStart32);
    }

    public static void printInfo(String string) {
        System.out.println("\nstring = " + string);
        System.out.println("length = " + string.length());
    }

    public static void printInfo(StringBuilder builder) {
        System.out.println("\nstring builder = " + builder);
        System.out.println("length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
    }
}
