
//! 3160. Find the Number of Distinct Colors Among the Balls (Medium)

// You are given an integer limit and a 2D array queries of size n x 2.
// There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored.
// For every query in queries that is of the form [x, y], you mark ball x with the color y.
// After each query, you need to find the number of distinct colors among the balls.

// Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.
// Note : that when answering a query, lack of a color will not be considered as a color.


import java.util.HashMap;

public class FindNumberDistinctColorsAmongBalls {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] queryResults(int limit, int[][] queries) {
            HashMap<Integer, Integer> map = new HashMap<>();       // Maps x -> y
            HashMap<Integer, Integer> freqMap = new HashMap<>();   // Tracks frequency of y

            int n = queries.length;
            int[] ans = new int[n];  // Result array

            for (int i = 0; i < n; i++) {
                int x = queries[i][0];
                int y = queries[i][1];

                // If x already exists, decrease the count of the old value
                if (map.containsKey(x)) {
                    int oldY = map.get(x);
                    freqMap.put(oldY, freqMap.get(oldY) - 1);

                    // Remove from freqMap if the count becomes zero
                    if (freqMap.get(oldY) == 0) {
                        freqMap.remove(oldY);
                    }
                }

                // Update the map and frequency of the new value
                map.put(x, y);
                freqMap.put(y, freqMap.getOrDefault(y, 0) + 1);

                // Store the current number of unique values
                ans[i] = freqMap.size();
            }

            return ans;
        }
    }

}
