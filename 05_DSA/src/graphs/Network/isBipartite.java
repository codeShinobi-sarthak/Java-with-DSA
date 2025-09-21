package graphs.Network;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {
    public static void main(String[] args) {
//        System.out.println(checkBipartite());
    }

    public boolean checkBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // Initialize all vertices as uncolored (-1)

        // Traverse each connected component
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // Unvisited node
                // Use BFS to color the graph
                if (!bfs(graph, i, color)) {
                    return false; // If not bipartite, return false
                }
            }
        }
        return true; // All components are bipartite
    }

    private boolean bfs(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // Assign the first color to the starting node

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    // Assign the opposite color to the neighbor
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // If the neighbor has the same color as the current node, it's not bipartite
                    return false;
                }
            }
        }
        return true; // This component is bipartite
    }
}
