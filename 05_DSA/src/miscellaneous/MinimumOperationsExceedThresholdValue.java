package miscellaneous;

import java.util.PriorityQueue;
import java.util.*;

//! Minimum Operations to Exceed Threshold Value II
 /*
You are given a 0-indexed integer array nums, and an integer k.
In one operation, you will:
   Take the two smallest integers x and y in nums.
   Remove x and y from nums.
   Add min(x, y) * 2 + max(x, y) anywhere in the array.

//* Note that you can only apply the described operation if nums contains at least two elements.

Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
*/

public class MinimumOperationsExceedThresholdValue {
    public static void main(String[] args) {

    }

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }
        long numOperations = 0;
        while (pq.peek() < k) {
            long first = pq.poll();
            long second = pq.poll();
            long num = 2 * Math.min(first, second) + Math.max(first, second);
            pq.add(num);
            numOperations++;
        }
        return (int) numOperations;
    }
}
