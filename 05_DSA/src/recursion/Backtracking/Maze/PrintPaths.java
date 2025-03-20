package Backtracking.Maze;

import java.util.ArrayList;

public class PrintPaths {
    public static void main(String[] args) {
//        pathPrint(3, 3, "");
//        System.out.println(pathPrintDiagonal(3, 3, ""));


//        boolean[][] maze = {
//                {true, true, true},
//                {true, false, true},
//                {true, true, true}
//        };
//
//        pathRestrictions(0, 0, "", maze);
    }

    public static void pathPrint(int r, int c, String path) {
        if (r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if (r > 1) {
            pathPrint(r - 1, c, path + "D");
        }
        if (c > 1) {
            pathPrint(r, c - 1, path + "R");
        }
    }

    public static ArrayList<String> pathPrintDiagonal(int r, int c, String path) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();


        if (r > 1) {
            list.addAll(pathPrintDiagonal(r - 1, c, path + "D"));
        }
        if (r > 1 && c > 1) {
            list.addAll(pathPrintDiagonal(r - 1, c - 1, path + "X"));
        }
        if (c > 1) {
            list.addAll(pathPrintDiagonal(r, c - 1, path + "R"));
        }
        return list;
    }

    private static void pathRestrictions(int r, int c, String path, boolean[][] maze) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            pathRestrictions(r + 1, c, path + "D", maze);
        }
        if (c < maze[0].length - 1) {
            pathRestrictions(r, c + 1, path + "R", maze);
        }
    }
}
