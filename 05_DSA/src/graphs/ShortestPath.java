import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {

    Set<int[]> firstIsland = new HashSet<>();
    Set<int[]> secondIsland = new HashSet<>();

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        boolean foundFirstIsland = false;

        // Step 1: Identify the first island and mark its coordinates in `firstIsland`
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    markIsland(grid, visited, i, j, firstIsland, n);
                    foundFirstIsland = true;
                    break;
                }
            }
            if (foundFirstIsland) break; // Only need to mark the first island
        }

        // Step 2: Use BFS from the first island to find the shortest path to the second island
        Queue<int[]> queue = new LinkedList<>(firstIsland);
        int steps = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int newX = cell[0] + dir[0];
                    int newY = cell[1] + dir[1];

                    // Check bounds and visited status
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                        if (grid[newX][newY] == 1) return steps; // Found the second island
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return -1; // If no path is found (shouldn't happen given problem constraints)
    }

    // Helper method to mark all cells of an island using DFS
    private void markIsland(int[][] grid, boolean[][] visited, int i, int j, Set<int[]> island, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;
        island.add(new int[]{i, j});
        markIsland(grid, visited, i + 1, j, island, n);
        markIsland(grid, visited, i - 1, j, island, n);
        markIsland(grid, visited, i, j + 1, island, n);
        markIsland(grid, visited, i, j - 1, island, n);
    }
}
