package arrays.multidimentionalArray;

import java.util.Arrays;

public class Main {
//    searching in 2D arrays


    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 5},
                {3, 6, 9},
                {11, 15, 34},
        };
        int target = 1;

        System.out.println(Arrays.toString(SearchIn2DArray(arr, target)));
    }

    private static int[] SearchIn2DArray(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[row].length; col++){
                if (arr[row][col] == target){
                    System.out.print("Element found at index : ");
                    return new int[]{row, col};
                }
            }
        }
        System.out.print("Element not found!! ");
        return new int[]{-1};
    }
}
