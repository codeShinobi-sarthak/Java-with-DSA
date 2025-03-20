package mediumQestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };

        System.out.println(spiralOrder(matrix));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    //    spiral matrix I
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

//     spiral matrix II
    public static  int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int num = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }
}
