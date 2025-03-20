package exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 4;
        int b = 0;

        try {
//            int c = a / b;
//            System.out.println(c);c

            String name = "sarth";
            if (name == "sarth") {
                throw new MyException("my name exception");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ArithmeticException("this is arithematic exception");
        } finally {
            System.out.println("This will always execute no matter what error is");
        }

    }
}
