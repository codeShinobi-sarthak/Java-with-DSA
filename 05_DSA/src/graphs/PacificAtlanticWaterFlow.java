import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Perform DFS
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);       // Left edge (Pacific)
            dfs(heights, atlantic, i, n - 1); // Right edge (Atlantic)
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);       // Top edge (Pacific)
            dfs(heights, atlantic, m - 1, j); // Bottom edge (Atlantic)
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int m = heights.length, n = heights[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n &&
                    !visited[x][y] && heights[x][y] >= heights[i][j]) {
                dfs(heights, visited, x, y);
            }
        }
    }

}
