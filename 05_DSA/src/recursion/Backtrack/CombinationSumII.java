package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void helper(int[] candidates, int target, int index, List<Integer> curList, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
            curList.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, curList, ans);
            curList.remove(curList.size() - 1);
        }
    }

}

