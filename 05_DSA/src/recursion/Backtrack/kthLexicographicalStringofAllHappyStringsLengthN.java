package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class kthLexicographicalStringofAllHappyStringsLengthN {

    public String getHappyString(int n, int k) {
        List<String> ans = new ArrayList<>();
        char[] letters = {'a', 'b', 'c'};
        backtrack(n, letters, new StringBuilder(), ans, k);
        return ans.size() >= k ? ans.get(k - 1) : "";  // Adjusting for 1-indexed k.
    }

    private void backtrack(int n, char[] letters, StringBuilder curr, List<String> ans, int k) {
        // Base case: if the current string is of length n, add to results.
        if (curr.length() == n) {
            ans.add(curr.toString());
            return;
        }

        // If we've already found k strings, we can stop further recursion.
        if (ans.size() == k) {
            return;
        }

        for (int i = 0; i < letters.length; i++) {
            // Check: avoid adding the same letter consecutively.
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == letters[i]) continue;

            curr.append(letters[i]);
            backtrack(n, letters, curr, ans, k);
            curr.deleteCharAt(curr.length() - 1);  // Backtrack.
        }
    }



}
