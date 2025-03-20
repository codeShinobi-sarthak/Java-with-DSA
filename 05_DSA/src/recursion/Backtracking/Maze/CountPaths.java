package Backtracking.Maze;

public class CountPaths {
    public static void main(String[] args) {
        System.out.println(countPath(3, 3));

    }

    public static int countPath(int r, int c) {
        if (r == 1 || c == 1) return 1;

//        int diagnol = countPath(r - 1, c - 1);
        int right = countPath(r, c - 1);
        int down = countPath(r - 1, c);
        return right + down;
    }
}
