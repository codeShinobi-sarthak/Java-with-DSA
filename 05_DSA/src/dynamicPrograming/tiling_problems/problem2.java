package tiling_problems;
import java.util.*;

// Problem Statement: Generalized Tiling Problem
//
// You are given a floor of length N and a set of tile sizes {t1, t2, ..., tk}.
// Your task is to find the number of ways to completely fill the floor using
// any combination of these tiles.
//
// Constraints:
// - 1 ≤ N ≤ 10^5
// - 1 ≤ k ≤ 50
// - 1 ≤ ti ≤ N
//
// Example 1:
// Input: N = 4, Tiles = [1, 2, 3]
// Output: 7
// Explanation: Possible ways to fill N = 4 using tiles {1, 2, 3}:
// 1. {1, 1, 1, 1}
// 2. {1, 1, 2}
// 3. {1, 2, 1}
// 4. {2, 1, 1}
// 5. {2, 2}
// 6. {1, 3}
// 7. {3, 1}
//
// Example 2:
// Input: N = 5, Tiles = [1, 3, 4]
// Output: 6
// Explanation: Possible ways to fill N = 5 using {1, 3, 4}:
// 1. {1, 1, 1, 1, 1}
// 2. {1, 1, 3}
// 3. {1, 3, 1}
// 4. {3, 1, 1}
// 5. {1, 4}
// 6. {4, 1}

public class problem2 {
    public static void main(String[] args) {
        // Define the block length
        int blockLength = 5;

        // Define the available tile sizes (e.g., 1, 2, and 4)
        List<Integer> tileSizes = List.of(1, 3, 4);

        // Call the function to compute the number of ways
        // (Function implementation will be done later)
        System.out.println("Number of ways to arrange tiles: " + countWays(blockLength, tileSizes));
    }

    // Function to count ways to fill a block of length N using given tile sizes
    private static int countWays(int blockLength, List<Integer> tileSizes) {
        if (blockLength == 0) return 1; // Base case for empty placement

        int[] dp = new int[blockLength + 1];
        dp[0] = 1; // There's only one way to fill length 0 (empty)

        for (int i = 1; i <= blockLength; i++) { // Start from 1 instead of initializing dp[1]
            for (int size : tileSizes) {
                if (size <= i) {
                    dp[i] += dp[i - size];
                }
            }
        }

        return dp[blockLength];
    }

}
