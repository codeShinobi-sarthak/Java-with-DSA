package SortingAlgorithms;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void countingSort(int[] arr) {
        int len = arr.length;
        int max = arr[0];

//      get the max element in array
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

//        create an array of size (max + 1) and count freq of numbers in array
        int[] freqArray = new int[max + 1];

        for (int i : arr) {
            freqArray[i]++;
        }

//        create a sorted array
        int index = 0;
        for (int i = 0; i < max; i++) {
            while (freqArray[i] > 0) {
                arr[index] = i;
                index++;
                freqArray[i]--;
            }
        }
    }
}
