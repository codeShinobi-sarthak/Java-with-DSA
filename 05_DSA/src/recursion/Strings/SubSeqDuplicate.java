package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSeqDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2};

        System.out.println(subSeqDuplicate(arr));
        System.out.println(subsetDuplicate(arr));

        subSeqDuplicate2(arr);
    }

    //    without recursion
    private static List<List<Integer>> subSeqDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        int cur = 0;

        for (int nums : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                if (cur != nums) {
                    List<Integer> inner = new ArrayList<>(outer.get(i));
                    inner.add(nums);
                    outer.add(inner);
                } else {
                    List<Integer> inner = new ArrayList<>(outer.get(i + n / 2));
                    inner.add(nums);
                    outer.add(inner);
                    if (i == n / 2 - 1) break;
                }
            }
            cur = nums;
//            System.out.println(outer);  // for testing every output
        }
        return outer;
    }

    //    without recursion second way
    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same, s = e + 1
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

    //    by recursion
    private static void subSeqDuplicate2(int[] arr) {

    }
}
