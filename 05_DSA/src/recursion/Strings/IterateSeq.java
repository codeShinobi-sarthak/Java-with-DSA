package Strings;

import java.util.ArrayList;
import java.util.List;

public class IterateSeq {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println(iterateSeq(arr));

    }

    private static List<List<Integer>> iterateSeq(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>()); // Add empty subsequence

        for (int i = 0; i < arr.length; i++) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

}
