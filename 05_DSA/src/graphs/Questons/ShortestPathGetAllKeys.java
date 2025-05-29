package graphs.Questons;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGetAllKeys {
    public static void main(String[] args) {

    }

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int startRow = 0, startCol = 0, totalKeys = 0;

        // Parse the grid to find the starting position and count total keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);
                if (cell >= 'a' && cell <= 'f') {
                    totalKeys++;
                }
                if (cell == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int allKeysMask = (1 << totalKeys) - 1; // Bitmask representing all keys collected
        boolean[][][] visited = new boolean[m][n][1 << totalKeys]; // Track {row, col, keys}

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0}); // {row, col, keys}
        visited[startRow][startCol][0] = true;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1], keys = current[2];

                if (keys == allKeysMask) {
                    return steps; // Return steps when all keys are collected
                }

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX].charAt(newY) != '#') {
                        char cell = grid[newX].charAt(newY);
                        int newKeys = keys;

                        if (cell >= 'a' && cell <= 'f') {
                            newKeys |= (1 << (cell - 'a')); // Collect the key
                        }
                        if (cell >= 'A' && cell <= 'F' && (newKeys & (1 << (cell - 'A'))) == 0) {
                            continue; // Skip if lock is encountered without a key
                        }
                        if (!visited[newX][newY][newKeys]) {
                            visited[newX][newY][newKeys] = true;
                            queue.add(new int[]{newX, newY, newKeys});
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // Return -1 if all keys cannot be collected
    }

}
