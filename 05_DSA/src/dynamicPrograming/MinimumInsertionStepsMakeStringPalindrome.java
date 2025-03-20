

//! leetcode 1312
// Given a string s. In one step you can insert any character at any index of the string.
// Return the minimum number of steps to make s palindrome.
// A Palindrome String is one that reads the same backward as well as forward.


public class MinimumInsertionStepsMakeStringPalindrome {
    public static void main(String[] args) {

    }
    
    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        return n - helperLCS(s, rev, n);
    }

    private int helperLCS(String s, String rev, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];
    }
}
