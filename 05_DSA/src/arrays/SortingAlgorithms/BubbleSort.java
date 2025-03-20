package arrays.SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int size = array.length;

//        for (int i = 0; i < size-1; i++){
//            for (int j = 0; j < size-1; j++){
//                if (array[j] > array[j+1]){
//                    int temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
//                }
//            }
//        }


//        more efficient code
        for (int i = 0; i < size - 1; i++) {
            // check if swapping occurs
            boolean swapped = false;
            for (int j = 0; j < size - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }
            // no swapping means the array is already sorted
            // so no need for further comparison
            if (!swapped)
                break;
        }


        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {12, 3, 45, 53, 2, 12};

        bubbleSort(array);
    }
}
