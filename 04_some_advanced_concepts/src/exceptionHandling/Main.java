package exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 4;
        int b = 3;

        try {
            System.out.println(divide(a, b));

            String name = "";
            if (name.equals("")) throw new MyException("something went wrong in MyException");

        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) { //? subclass should come fast i.e. ArithmeticException
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            System.out.println(e.toString());
//            throw new RuntimeException(e);
        } finally {
            System.out.println("This is the final block it will run no matter what");
        }
    }

    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException(" Do not divide by zero");

        return a / b;
    }
}
