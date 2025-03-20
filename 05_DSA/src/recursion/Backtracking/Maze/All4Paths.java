package Backtracking.Maze;

import java.util.ArrayList;
import java.util.Arrays;

public class All4Paths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

//        allPaths(0, 0, "", maze);

        int[][] steps = new int[maze.length][maze[0].length];
        allPathsWithPattern(0, 0, "", maze, steps, 1);
    }

    private static void allPaths(int r, int c, String path, boolean[][] maze) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false; // so that it don't go back to the path coming from

        if (r < maze.length - 1) {
            allPaths(r + 1, c, path + "D", maze);
        }
        if (c < maze[0].length - 1) {
            allPaths(r, c + 1, path + "R", maze);
        }
        if (r > 0) {
            allPaths(r - 1, c, path + "U", maze);
        }
        if (c > 0) {
            allPaths(r, c - 1, path + "L", maze);
        }

        maze[r][c] = true; // for the right part of recursion after left part done
    }

    private static void allPathsWithPattern(int r, int c, String path, boolean[][] maze, int[][] steps, int i) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            steps[r][c] = i;
            System.out.println(path + "\n");
            for(int[] arr : steps) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false; // so that it don't go back to the path coming from
        steps[r][c] = i;

        if (r < maze.length - 1) {
            allPathsWithPattern(r + 1, c, path + "D", maze, steps, i+1);
        }
        if (c < maze[0].length - 1) {
            allPathsWithPattern(r, c + 1, path + "R", maze, steps, i+1);
        }
        if (r > 0) {
            allPathsWithPattern(r - 1, c, path + "U", maze, steps, i+1);
        }
        if (c > 0) {
            allPathsWithPattern(r, c - 1, path + "L", maze, steps, i+1);
        }

        maze[r][c] = true; // for the right part of recursion after left part done
        steps[r][c] = 0;
    }
}
