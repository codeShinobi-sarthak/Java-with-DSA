package graphs.Questons;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {
        // Initialize the queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Traverse the grid to add rotten oranges and count fresh ones
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    // Add rotten orange to the queue (its position: i, j)
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    // Count fresh oranges
                    freshOranges++;
                }
            }
        }

        // At this point, all rotten oranges are in the queue, and we know how many fresh oranges we have
        return freshOranges == 0 ? -1 : bfs(grid, queue, freshOranges);
    }

    private int bfs(int[][] grid, Queue<int[]> queue, int freshOranges) {
        int minutes = 0;
        int n = grid.length;
        int m = grid[0].length;

        // Directions for moving in 4 adjacent directions (right, down, left, up)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Process the queue level by level (each level corresponds to 1 minute)
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedInThisMinute = false;

            // Process all oranges that will rot in this minute
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];

                // Explore the 4 directions (right, down, left, up)
                for (int[] direction : directions) {
                    int newI = i + direction[0];
                    int newJ = j + direction[1];

                    // Check if new position is within bounds and has a fresh orange
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 2;  // Rot the fresh orange
                        freshOranges--;  // Decrease the count of fresh oranges
                        queue.add(new int[]{newI, newJ});  // Add new rotten orange to queue
                        rottedInThisMinute = true;  // Mark that we rotted an orange in this minute
                    }
                }
            }

            // If we rotted any oranges in this minute, increment the time
            if (rottedInThisMinute) {
                minutes++;
            }
        }

        // If there are still fresh oranges left, return -1, otherwise return the minutes taken
        return freshOranges == 0 ? minutes : -1;
    }

}
