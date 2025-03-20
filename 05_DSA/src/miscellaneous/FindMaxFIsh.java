public class FindMaxFIsh {
    public static void main(String[] args) {

    }

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;

        // Iterate through every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Start DFS if the cell contains fish
                if (grid[i][j] != 0) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, int i, int j) {
        // Check boundaries and if the cell contains no fish
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // Collect the fish in the current cell
        int fish = grid[i][j];

        // Mark the cell as visited by setting it to 0
        grid[i][j] = 0;

        // Explore all 4 directions (up, down, left, right)
        fish += dfs(grid, i - 1, j); // Up
        fish += dfs(grid, i + 1, j); // Down
        fish += dfs(grid, i, j - 1); // Left
        fish += dfs(grid, i, j + 1); // Right

        return fish;
    }

}
