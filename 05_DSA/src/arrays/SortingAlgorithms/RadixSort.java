package SortingAlgorithms;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 123, 56, 456, 27, 334};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // Get the max number to know the number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Apply count sort to each digit
        for (int i = 1; max / i > 0; i *= 10) {
            countSort(arr, i);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];  // Output array
        int[] count = new int[10];  // Count array for digits 0-9

        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int j = 0; j < n; j++) {
            count[(arr[j] / exp) % 10]++;
        }

        // Change count[i] so that it now contains the actual position of this digit in output[]
        for (int j = 1; j < 10; j++) {
            count[j] += count[j - 1];
        }

        // Build the output array
        for (int j = n - 1; j >= 0; j--) {
            int index = (arr[j] / exp) % 10;
            output[count[index] - 1] = arr[j];
            count[index]--;
        }

        // Copy the output array to arr[], so that arr now contains sorted numbers
        System.arraycopy(output, 0, arr, 0, n);
    }
}
