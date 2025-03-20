


//   Given a 2D grid consists of 0s (land) and 1s (water).
//   An island is a maximal 4-directionally connected group of 0s and a closed island is an island
//   totally (all left, top, right, bottom) surrounded by 1s.
//   Return the number of closed islands.


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands {

    public static void main(String[] args) {

    }

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if it's land (0) and not visited
                if (!visited[i][j] && grid[i][j] == 0) {
                    // Perform BFS and check if it's a closed island
                    if (bfs(i, j, visited, grid, m, n)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean bfs(int row, int col, boolean[][] visited, int[][] grid, int m, int n) {
        boolean isClosed = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        // Directions for up, down, left, right
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];

            for (int[] direction : directions) {
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];

                // If out of bounds, it's not a closed island
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                    isClosed = false;
                    continue;
                }

                // If not visited and is land (0), continue BFS
                if (!visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return isClosed;
    }

}
