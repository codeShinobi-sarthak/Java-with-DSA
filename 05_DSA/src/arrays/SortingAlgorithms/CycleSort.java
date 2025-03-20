package SortingAlgorithms;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int cur = arr[i] - 1;
            if (arr[i] != i + 1) {
                int temp = cur;
                arr[cur] = arr[i];
                arr[i] = temp;
            } else i++;
        }
    }
}
