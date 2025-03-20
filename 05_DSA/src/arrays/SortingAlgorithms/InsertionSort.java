package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {7, 8, 3, 2, 1};

        for (int i = 1; i < array.length; i++){
            int current = array[i];
            int j = i-1;
            while (j >= 0 && current < array[j]){
                array[j+1] = array[j];
                j--;
            }
//            placement
            array[j+1] = current;
        }

        System.out.println(Arrays.toString(array));
   }
}


