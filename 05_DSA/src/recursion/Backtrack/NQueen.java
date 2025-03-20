package Backtrack;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(solveNQueens(board, 0));
    }

    //    * solving problem
    public static int solveNQueens(boolean[][] board, int r) {
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;

        for (int col = 0; col < board.length; col++) {
//            check if queen is safe to place
            if (isSafe(board, r, col)) {
                board[r][col] = true;
                count += solveNQueens(board, r + 1);
//              * backtrack
                board[r][col] = false;
            }
        }
        return count;
    }

    //    * method to check for if queen is safe to place here
    private static boolean isSafe(boolean[][] board, int row, int col) {
//        for vertically above
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

//        for diagonals left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - 1][col - 1]) return false;
        }

//        for diagonals right
        int maxRigth = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRigth; i++) {
            if (board[row - 1][col + 1]) return false;
        }

        return true;
    }

    //    * method to display board
    public static void display(boolean[][] board) {
        System.out.println("{");
        for (boolean[] row : board) {
            System.out.print("{");
            for (boolean i : row) {
                if (i) {
                    System.out.print("Q, ");
                } else {
                    System.out.print("x, ");
                }
            }
            System.out.println("}");
        }
        System.out.println("}");
    }

}
