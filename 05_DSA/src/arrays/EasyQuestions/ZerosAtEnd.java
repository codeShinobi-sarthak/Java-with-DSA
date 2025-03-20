package EasyQuestions;

import java.util.Arrays;

public class ZerosAtEnd {

    public static int[] zeroEnd(int[] array, int n) {
        int j = 0;
        for(int i = 0; i < n; i++){
            if (array[i] != 0 && array[j] == 0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if (array[j] != 0) j++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 4, 12};

        System.out.println("New array with zeros at the end is: " + Arrays.toString(zeroEnd(array, array.length)));
    }
}
