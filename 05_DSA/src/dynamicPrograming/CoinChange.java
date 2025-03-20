


//! 322. Coin Change
//You are given an integer array coins representing coins of different denominations and
// an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return -1.

// note: You may assume that you have an infinite number of each kind of coin.

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        // Edge case: if amount is 0, no coins are needed.
        if (amount == 0) return 0;

        // Initialize dp array where dp[i] will be storing the minimum coins needed for amount i.
        // We fill with a value greater than any possible answer.
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, max);
        dp[0] = 0;  // Base case: 0 coins needed for amount 0

        // Build up the dp table
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] has not been updated, then it's not possible to form that amount.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
