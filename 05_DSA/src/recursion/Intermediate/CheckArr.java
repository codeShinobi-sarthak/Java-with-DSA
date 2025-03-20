package Intermediate;

public class CheckArr {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 9, 11};

        if (checkSortedArray(arr, 0)) {
            System.out.println("Array is sorted");
        } else
            System.out.println("Array is not sorted");

//        solution 2
        System.out.println(checkSortedArray2(arr, 0));
    }

    public static boolean checkSortedArray(int[] arr, int i) {
        if (arr[i] > arr[i + 1]) return false;
        if (i == arr.length - 2) return true;

        return checkSortedArray(arr, ++i);
    }

    //    solution 2
    public static boolean checkSortedArray2(int[] arr, int i) {
        if (i == arr.length - 1) return true;

        return  arr[i] < arr[i + 1] && checkSortedArray2(arr, ++i);
    }
}
