package miscellaneous;

//! Link : https://leetcode.com/problems/apply-operations-to-maximize-score/editorial/?envType=daily-question&envId=2025-03-29

import java.util.*;

public class ApplyOperationstoMaximizeScore {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(8, 3, 9, 3, 8));
        System.out.println(maximumScore(nums, 2));
    }// Magical number to prevent overflow

    public static int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeScores = new int[n];

        // Prime Wizard calculates prime power for each knight
        for (int i = 0; i < n; i++) primeScores[i] = calcPrimeScore(nums.get(i));

        // Monotonic Guardians find left and right boundaries
        int[] left = new int[n], right = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && primeScores[st.peek()] < primeScores[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && primeScores[st.peek()] <= primeScores[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Sorting Sorcerer sorts the knights
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums.get(b) - nums.get(a));

        // Score Multiplier calculates the maximum score
        long score = 1;
        for (int i = 0; i < n && k > 0; i++) {
            int id = idx[i];
            long count = (long) (id - left[id]) * (right[id] - id);
            int ops = (int) Math.min(count, k);

            if (ops > 0) {
                score = (score * fastPow(nums.get(id), ops)) % MOD;
                k -= ops;
            }
        }

        return (int) score;
    }

    private static long fastPow(int base, int exp) {
        long res = 1, b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * b) % MOD;
            b = (b * b) % MOD;
            exp >>= 1;
        }
        return res;
    }

    private static int calcPrimeScore(int n) {
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) factors.add(n);
        return factors.size();
    }

}
