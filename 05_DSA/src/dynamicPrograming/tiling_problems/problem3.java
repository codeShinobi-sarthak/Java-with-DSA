package tiling_problems;

import java.util.*;

/*
 * Problem: Generalized Tiling with Custom Recurrence
 *
 * You are given a floor of length N and a set of tile sizes {t1, t2, ..., tk}.
 * Your task is to find the number of ways to completely fill the floor using
 * any combination of these tiles.
 *
 * Example:
 * tilesLengths : [1, 1, 2, 4]
 * N = 7
 * N = 25
 */

public class problem3 {
    public static void main(String[] args) {
        // Custom recurrence pattern: [1, 1, 2, 4] (Given as base cases)
        List<Integer> tilesLengths = List.of(1, 1, 2, 4);

        // Example test cases
        int blockLength1 = 7;
        int blockLength2 = 25;

        // Using recursive approach
        System.out.println("Using Recursive approach: ");
        System.out.println("Ways to tile a block of length " + blockLength1 + ": " + recursive(blockLength1, tilesLengths, new HashMap<>()));
        System.out.println("Ways to tile a block of length " + blockLength2 + ": " + recursive(blockLength2, tilesLengths, new HashMap<>()));

        // DP approach
        System.out.println("Using Dynamic Programming approach: ");
        System.out.println("Ways to tile a block of length " + blockLength1 + ": " + dp(blockLength1, tilesLengths));
        System.out.println("Ways to tile a block of length " + blockLength2 + ": " + dp(blockLength2, tilesLengths));
    }

    // Corrected Recursive Function with Memoization
    public static int recursive(int blockLength, List<Integer> tilesLengths, Map<Integer, Integer> memo) {
        if (blockLength == 0) return 1;  // Base case: One way to fill an empty floor
        if (blockLength < 0) return 0;   // Base case: No way to fill negative space
        if (memo.containsKey(blockLength)) return memo.get(blockLength);

        int ways = 0;
        for (int tile : tilesLengths) {
            ways += recursive(blockLength - tile, tilesLengths, memo);
        }

        memo.put(blockLength, ways);
        return ways;
    }

    // Corrected DP Function
    private static int dp(int blockLength, List<Integer> tilesLengths) {
        int[] dp = new int[blockLength + 1];
        dp[0] = 1;

        HashMap<Integer, Integer> tileFreq = new HashMap<>();
        for (int tileLength : tilesLengths) {
            tileFreq.put(tileLength, tileFreq.getOrDefault(tileLength, 0) + 1);
        }

        for (int i = 1; i <= blockLength; i++) {
            for (int tile : tileFreq.keySet()) {
                if (tile > i) {
                    continue;
                }
                dp[i] += dp[i - tile] * tileFreq.get(tile);
            }
        }
        return dp[blockLength];
    }
}
