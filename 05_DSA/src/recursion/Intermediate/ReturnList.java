package Intermediate;

import javax.swing.*;
import java.util.ArrayList;

// return are arraylist that have index of the target element
public class ReturnList {

    public static ArrayList<Integer> findAllIndex(int[] arr, int target, int i, ArrayList<Integer> list) {
        if (i == arr.length) return list;

        if (arr[i] == target) list.add(i);

        return findAllIndex(arr, target, ++i, list);
    }

//    Returning arraylist without passing the list arguments
    public static ArrayList<Integer> findAllIndex2(int[] arr, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();

        if (i == arr.length) return list;

//        checking and adding the index in the current list
        if (arr[i] == target) list.add(i);

        ArrayList<Integer> previousList = findAllIndex2(arr, target, ++i);
        list.addAll(previousList);

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {23, 4, 5, 2, 43, 5, 19};
        int target = 5;

        System.out.println("With passing List as Argument:  " + findAllIndex(arr, target, 0, new ArrayList<>()));

//
        System.out.println("Without passing list as argument: " + findAllIndex2(arr, target, 0));
    }
}
