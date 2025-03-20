import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // If the start or end is blocked, there's no valid path.
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        // Directions for moving in 8 possible ways
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        // BFS queue stores the cell coordinates and current path length
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // Start from (0, 0) with path length 1
        grid[0][0] = 1; // Mark as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int pathLength = current[2];

            if (x == m - 1 && y == n - 1) {
                return pathLength;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY, pathLength++});
                    grid[newX][newY] = 1;
                }
            }
        }

        // If no path is found, return -1
        return -1;
    }
}
