package EasyQuestions;

import java.util.ArrayList;
import java.util.List;

public class LuckyNoMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int r = matrix.length;
        int num = Integer.MAX_VALUE;
        int c = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (num > matrix[i][j]) {
                    num = matrix[i][j];
                    c = j;
                }
            }
            boolean flag = true;
            for (int row = 0; row < r; row++) {
                if (matrix[row][c] > num) flag = false;
            }
            if (flag) ans.add(num);
            num = Integer.MAX_VALUE;
        }
        return ans;
    }

}
