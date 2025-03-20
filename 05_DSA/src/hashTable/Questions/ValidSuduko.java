package Questions;

import java.util.HashSet;

public class ValidSuduko {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        // Use arrays of sets to keep track of the characters seen
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];

        // Initialize the sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        // Traverse the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                int squareIndex = (i / 3) * 3 + (j / 3);

                if (rows[i].contains(num) || cols[j].contains(num) || squares[squareIndex].contains(num)) {
                    return false;
                }

                rows[i].add(num);
                cols[j].add(num);
                squares[squareIndex].add(num);
            }
        }
        return true;
    }
}
