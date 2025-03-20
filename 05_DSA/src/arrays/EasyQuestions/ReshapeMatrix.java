package EasyQuestions;

import java.util.Arrays;

public class ReshapeMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(matrixReshape(arr, 2, 4)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) return mat;
        int[][] ans = new int[r][c];

        int x = 0, y = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                ans[x][y] = mat[i][j];
                y++;
                if (y == c) {
                    y = 0;
                    x++;
                }
            }
        }
        return ans;
    }
}
