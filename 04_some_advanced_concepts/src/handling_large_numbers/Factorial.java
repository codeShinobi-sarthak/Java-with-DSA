package handling_large_numbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Factorial {
    public BigInteger factorial(int num) {
        BigInteger ans = new BigInteger("1");

        for (int i = 2; i <= num; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        return ans;
    }
}
