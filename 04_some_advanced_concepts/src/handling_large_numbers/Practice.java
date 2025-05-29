package handling_large_numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Practice {
    public static void main(String[] args) {
//        BI();
//        BD();

    }

    static void BD() {

        BigDecimal bigDec = new BigDecimal("123.456");
        double doubleValue = bigDec.doubleValue(); // Convert to double
        String strValue = bigDec.toString(); // Convert to String

//        As a currency calculator
        BigDecimal price = new BigDecimal("10.99");
        BigDecimal quantity = new BigDecimal("3");
        BigDecimal total = price.multiply(quantity);

        BigDecimal taxRate = new BigDecimal("0.07"); // 7% tax
        BigDecimal tax = total.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal finalAmount = total.add(tax);

        System.out.println("Total before tax: " + total);  // 32.97
        System.out.println("Tax: " + tax);  // 2.31
        System.out.println("Final amount: " + finalAmount); // 35.28



//      Rounding methods
        BigDecimal num = new BigDecimal("2.555");

        System.out.println(num.setScale(2, RoundingMode.HALF_UP)); // 2.56
        System.out.println(num.setScale(2, RoundingMode.HALF_DOWN)); // 2.55
        System.out.println(num.setScale(2, RoundingMode.CEILING)); // 2.56
        System.out.println(num.setScale(2, RoundingMode.FLOOR)); // 2.55
    }

    static void BI() {
        int a = 33;
        int b = 83;

        BigInteger A = BigInteger.valueOf(33);
        System.out.println("A: " + A);
        BigInteger B = BigInteger.valueOf(378286272);
        System.out.println("B: " + B);
        BigInteger C = new BigInteger("454465165165461611651");
        System.out.println("C: " + C);
        BigInteger X = new BigInteger("48944545165155615615615");
        System.out.println("X: " + X);


        BigInteger bigInt = new BigInteger("100000");
        int intValue = bigInt.intValue();  // Convert to int
        long longValue = bigInt.longValue(); // Convert to long
        String strValue = bigInt.toString(); // Convert to String

//       Constants
        BigInteger D = BigInteger.TEN;
        System.out.println("D: " + D);

//        Addition (other Operations can also be done)
//       ? see documentation
        BigInteger E = A.add(B);
        System.out.println("E: " + E);

//        factorial of a big number
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(489489489));
    }

}
