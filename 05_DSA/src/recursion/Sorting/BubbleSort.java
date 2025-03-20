package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr, int n, int i) {
//        base condition
        if (n == 0) return arr;

        if (i != n){
            if (arr[i] > arr[i+1]) {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
            return bubbleSort(arr, n, ++i);
        }
        else return bubbleSort(arr, --n, 0);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 5, 1};
        System.out.println(Arrays.toString(bubbleSort(arr,arr.length-1, 0)));
    }
}
