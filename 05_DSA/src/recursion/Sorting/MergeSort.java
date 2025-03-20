package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

//        returning a new array not modifying the array but creating a new array
//        System.out.println(Arrays.toString(mergeSort(arr)));

        mergeSortInPlace(arr, 0, arr.length); // modifying the current array
        System.out.println(Arrays.toString(arr));
    }


    //    -----------------------------------------------------------------------------------------------------------
    private static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 1) return;

        int mid = (start + end) / 2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    public static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] ans = new int[e - s];

        int i = s, j = m, k = 0;

        while (i < m && j < e) {
            if (arr[i] > arr[j]) {
                ans[k] = arr[j];
                j++;
            } else {
                ans[k] = arr[i];
                i++;
            }
            k++;
        }

        while (i < m) {
            ans[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            ans[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < ans.length; l++) {
            arr[s + l] = ans[l];
        }
    }


    //    -----------------------------------------------------------------------------------------------------------
    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length / 2;

        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

//        method to merge left and right part of arrays
        return merge(leftArr, rightArr);
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int[] ans = new int[leftArr.length + rightArr.length];

        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] > rightArr[j]) {
                ans[k] = rightArr[j];
                j++;
            } else {
                ans[k] = leftArr[i];
                i++;
            }
            k++;
        }

        while (i < leftArr.length) {
            ans[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            ans[k] = rightArr[j];
            j++;
            k++;
        }

        return ans;
    }
}
