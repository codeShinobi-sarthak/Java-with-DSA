package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 11, 18, 7, 8, 9};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(end > start){
            int p = partition(arr, start, end);

            quickSort(arr, start, p-1);
            quickSort(arr, p+1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int i = start;
        int pivot = end;
        for (int j = start; j < end; j++){
            if (arr[pivot] > arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
//        pivot swap
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;

        return i;
    }

}
