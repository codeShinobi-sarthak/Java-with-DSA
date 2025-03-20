package Backtrack;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(sudoku)) {
            display(sudoku);
        } else {
            System.out.println("Cannot solve");
        }

    }


    public static boolean solve(int[][] sudoku) {
        int n = sudoku.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        // this is how we are replacing the r,c from arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sudoku[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if you found some empty element in row, then break
            if (!emptyLeft) break;
        }

        if (emptyLeft) return true;

        // backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSafe(sudoku, row, col, number)) {
                sudoku[row][col] = number;
                if (solve(sudoku)) {
                    // found the answer
                    return true;
                } else {
                    // backtrack
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }


    public static boolean isSafe(int[][] sudoku, int row, int col, int num) {
        for (int[] ints : sudoku) {
            if (ints[col] == num) return false;
        }

        for (int i = 0; i < sudoku[0].length; i++) {
            if (sudoku[row][i] == num) return false;
        }
        int sqrt = (int) (Math.sqrt(sudoku.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < sqrt; i++) {
            for (int j = colStart; j < sqrt; j++) {
                if (sudoku[i][j] == num) return false;
            }
        }
        return true;
    }

    private static void display(int[][] sudoku) {
        for (int[] row : sudoku) {
            for (int num : row) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
