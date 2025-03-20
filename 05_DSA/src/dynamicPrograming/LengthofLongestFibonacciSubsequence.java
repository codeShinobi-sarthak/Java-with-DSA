

//! link : https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/?envType=daily-question&envId=2025-02-27
// 873. Length of Longest Fibonacci Subsequence

/*
Input: arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
*/

import java.util.*;

public class LengthofLongestFibonacciSubsequence {
    public static void main(String[] args) {

    }

    // TODO:  dp solution
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int curr = 2; curr < n; curr++) {
            int start = 0;
            int end = curr - 1;

            while (end > start) {
                int pairSum = arr[curr] + arr[end];

                if (pairSum > arr[curr]) {
                    end--;
                } else if (pairSum < arr[curr]) {
                    start++;
                } else {
                    dp[end][curr] = dp[start][end] + 1;          //! main logic
                    maxLen = Math.max(dp[end][curr], maxLen);
                    end--;
                    start++;
                }
            }
        }
        // Add 2 to include first two numbers, or return 0 if no sequence found
        return maxLen == 0 ? 0 : maxLen + 2;
    }


// ?  this is the iterative solution
//    public int lenLongestFibSubseq(int[] arr) {
//        HashSet<Integer> set = new HashSet<>();
//        int n = arr.length;
//
//        for (int num : arr) {
//            set.add(num);
//        }
//
//        int maxLen = 0;
//
//        for (int start = 0; start < n; start++) {
//            for (int next = start + 1; next < n; next++) {
//                int first = arr[start];
//                int second = arr[next];
//                int third = first + second;
//                int currLen = 2;
//                while (set.contains(third)) {
//                    first = second;
//                    second = third;
//                    third = first + second;
//                    maxLen = Math.max(maxLen, ++currLen);
//                }
//            }
//        }
//
//        return maxLen;
//    }
}
