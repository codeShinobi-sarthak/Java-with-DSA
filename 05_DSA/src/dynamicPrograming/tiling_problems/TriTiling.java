package tiling_problems;

//! Link to problem : https://open.kattis.com/problems/tritiling

// In how many ways can you tile a (3xN) rectangle with (2x1) dominoes?

// INPUT | OUTPUT
//    2  | 3
//    8  | 153
//   12  | 2131
//   -1  |


public class TriTiling {
    public static void main(String[] args) {
        int n = 8;

        System.out.println(triTiling(n));
    }

    private static int triTiling(int n) {
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        // Fill the DP table for even indices
        for (int i = 4; i <= n; i += 2) {
            dp[i] = 4 * dp[i - 2] - dp[i - 4];
        }

        return dp[n];
    }


}
