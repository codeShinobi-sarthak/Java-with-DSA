

// You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
// Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
//
// You are given two arrays redEdges and blueEdges where:
//    - redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
//    - blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
//
// Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x
// such that the edge colors alternate along the path, or -1 if such a path does not exist.


import java.util.*;

public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {

    }

//    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
//        // Adjacency lists for red and blue edges
//        List<List<Integer>> redAdj = new ArrayList<>();
//        List<List<Integer>> blueAdj = new ArrayList<>();
//
//        // Initialize adjacency lists
//        for (int i = 0; i < n; i++) {
//            redAdj.add(new ArrayList<>());
//            blueAdj.add(new ArrayList<>());
//        }
//
//        // Populate adjacency lists for red edges
//        for (int[] edge : redEdges) {
//            redAdj.get(edge[0]).add(edge[1]);
//        }
//
//        // Populate adjacency lists for blue edges
//        for (int[] edge : blueEdges) {
//            blueAdj.get(edge[0]).add(edge[1]);
//        }
//
//        // Result array to store the shortest path to each node
//        int[] result = new int[n];
//        Arrays.fill(result, -1); // Initialize with -1 (unreachable)
//
//        // Queue for BFS: Pair(node, color) -> color: 0 (red), 1 (blue)
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//
//        // Visited array to track visited nodes for each color
//        boolean[][] visited = new boolean[n][2];
//
//        // Starting point: node 0 with both colors
//        queue.add(new Pair<>(0, 0)); // Starting with red edge
//        queue.add(new Pair<>(0, 1)); // Starting with blue edge
//        visited[0][0] = true; // Mark as visited for red
//        visited[0][1] = true; // Mark as visited for blue
//        result[0] = 0; // Distance to start node is 0
//
//        int level = 1; // BFS level for distance calculation
//
//        // BFS loop
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            // Process all nodes at the current level
//            for (int i = 0; i < size; i++) {
//                Pair<Integer, Integer> current = queue.poll();
//                int node = current.getKey();
//                int color = current.getValue();
//
//                // Get the next edges based on the current color
//                List<Integer> nextEdges = (color == 0) ? blueAdj.get(node) : redAdj.get(node);
//                int nextColor = (color == 0) ? 1 : 0; // Alternate color
//
//                for (int neighbor : nextEdges) {
//                    if (!visited[neighbor][nextColor]) {
//                        queue.add(new Pair<>(neighbor, nextColor));
//                        visited[neighbor][nextColor] = true;
//
//                        // Update result only if this is the first visit to the node
//                        if (result[neighbor] == -1) {
//                            result[neighbor] = level;
//                        }
//                    }
//                }
//            }
//
//            level++; // Increment BFS level
//        }
//
//        return result;
//    }

}
