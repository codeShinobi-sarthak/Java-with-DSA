
//! Link: https://leetcode.com/problems/closest-prime-numbers-in-range/?envType=daily-question&envId=2025-03-07

//Given two positive integers left and right, find the two integers num1 and num2 such that:
// -  left <= num1 < num2 <= right .
// -  Both num1 and num2 are prime numbers.
// -  num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.

//Return the positive integer array ans = [num1, num2].
// If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value.
// If no such numbers exist, return [-1, -1].


import java.util.*;

public class ClosestPrimeNumbersRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(1, 1000000)));
    }

    public static int[] closestPrimes(int left, int right) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {

                if (!primeNumbers.isEmpty() && i - primeNumbers.get(primeNumbers.size() - 1) <= 2) {
                    return new int[]{primeNumbers.get(primeNumbers.size() - 1), i};

                }
                primeNumbers.add(i);
            }
        }

        if (primeNumbers.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[]{-1, -1};
        for (int i = 1; i < primeNumbers.size(); i++) {
            int currDiff = primeNumbers.get(i) - primeNumbers.get(i - 1);

            if (currDiff < minDiff) {
                ans[1] = primeNumbers.get(i);
                ans[0] = primeNumbers.get(i - 1);
                minDiff = currDiff;
            }

        }

        return ans;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
