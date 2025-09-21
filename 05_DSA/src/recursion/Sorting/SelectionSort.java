package recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 8, 9, 3};
        System.out.println(Arrays.toString(selectionSort(arr, 0, 1, arr.length - 1)));
    }

    private static int[] selectionSort(int[] arr, int max, int i, int j) {
        if (j == 0) return arr; // base condition

        if (i <= j) {
            if (arr[max] < arr[i]) {
                return selectionSort(arr, i, ++i, j);
            }
            return selectionSort(arr, max, ++i, j);
        } else {
            int temp = arr[j];
            arr[j] = arr[max];
            arr[max] = temp;
        }
        return selectionSort(arr, 0, 1, --j);
    }
}
