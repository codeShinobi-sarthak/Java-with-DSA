package EasyQuestions;

import java.util.ArrayList;

public class Basic {
    public static void main(String[] args) {
        int[] array = {57, 6, 7, 14, 11, 29, 44};

        PrintElements(array);
        System.out.println("\nArray with even numbers: " + EvenArray(array));;
    }


    //  print elements of an array
    public static void PrintElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element at index " + i + " is :" + array[i]);
        }
    }


//returning array with only even numbers
    public static ArrayList<Integer> EvenArray(int[] array){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        int j = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
               myList.add(array[i]);
               j++;
            }
        }
        return myList;
    }
}