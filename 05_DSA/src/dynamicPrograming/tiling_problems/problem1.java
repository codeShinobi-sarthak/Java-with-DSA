package tiling_problems;

// You are given 2 types of tiles:
// - Red tile of size 1
// - Blue tile of size 2
// Find the number of ways to arrange them on a block of some length.

import java.util.HashMap;

public class problem1 {
    public static void main(String[] args) {
        int blocks = 7;

        // Recursive solution (Exponential Time Complexity)
        System.out.println("Recursive without memoization: " + recursive(blocks));

        // Memoized Recursive Solution (Top-Down DP)
        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println("Recursive with memoization: " + recursiveWithMemo(blocks, memo));

        // Bottom-Up DP Approach (Iterative)
        System.out.println("Dynamic Programming approach: " + dynamicProgramming(blocks));
    }

    // Bottom-Up DP (Tabulation)
    private static int dynamicProgramming(int blocks) {
        if (blocks == 0) return 1; // Base case: 1 way to arrange nothing
        if (blocks == 1) return 1; // Only one way: 1 red tile

        int[] dp = new int[blocks + 1];
        dp[0] = 1; // 1 way to arrange 0 blocks (do nothing)
        dp[1] = 1; // Only 1 way to arrange 1 block (1 red tile)

        for (int i = 2; i <= blocks; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // Choice: Place a red tile (size 1) or a blue tile (size 2)
        }

        return dp[blocks];
    }

    // Recursive with Memoization (Top-Down DP)
    private static int recursiveWithMemo(int blocks, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(blocks)) {
            return memo.get(blocks);
        }
        if (blocks == 0) return 1; // Base case should be 1 (doing nothing is a valid way)
        if (blocks == 1) return 1; // Only one way: 1 red tile

        int ways = recursiveWithMemo(blocks - 1, memo) + recursiveWithMemo(blocks - 2, memo);
        memo.put(blocks, ways);
        return ways;
    }

    // Recursive (Brute Force, Exponential Time Complexity)
    private static int recursive(int blocks) {
        if (blocks == 0) return 1; //  Base case should be 1
        if (blocks == 1) return 1; // Only one way: 1 red tile

        return recursive(blocks - 1) + recursive(blocks - 2);
    }
}
