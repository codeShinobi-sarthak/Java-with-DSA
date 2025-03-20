package EasyQuestions;

import java.util.Arrays;

public class ReverseArray {

    public static int[] reverseArray(int[] array, int n){

//  using for loop

//        for (int i = 0; i <= n/2; i++){
//            int temp = array[i];
//            array[i] = array[n-1];
//            array[n-1] = temp;
//            n--;
//        }

//  using while loop
        int i = 0;
        while(i<n){
            int temp = array[i];
            array[i] = array[n-1];
            array[n-1] = temp;
            i++;
            n--;
        }
        System.out.println(array);
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 11, 2, 7, 8, 10};

        System.out.println(Arrays.toString(reverseArray(array, array.length)));;
    }
}
