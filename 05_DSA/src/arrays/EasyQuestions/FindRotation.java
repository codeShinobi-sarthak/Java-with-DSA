package EasyQuestions;

public class FindRotation {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(findRotation(matrix, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int times = 0;

        while (times < 4) {
            int[][] result = rotate(mat);
            if (checkEqual(result, target)) return true;
            mat = result;
            times++;
        }
        return false;
    }

    private static int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - i - 1] = mat[i][j];
            }
        }
        return ans;
    }

    private static boolean checkEqual(int[][] ans, int[][] target) {
        int n = ans.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }

}
