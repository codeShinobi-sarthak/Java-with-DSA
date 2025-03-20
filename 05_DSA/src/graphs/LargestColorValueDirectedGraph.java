import java.util.*;

public class LargestColorValueDirectedGraph {
    public static void main(String[] args) {

    }

//    public int largestPathValue(String colors, int[][] edges) {
//        int nodes = colors.length();
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        int[] inDegree = new int[nodes];
//        int[][] colorCount = new int[nodes][26]; // Tracks color counts for each node
//
//        // Build the graph and compute in-degree
//        for (int[] edge : edges) {
//            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
//            inDegree[edge[1]]++;
//        }
//
//        // Initialize the queue with nodes having in-degree 0
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < nodes; i++) {
//            if (inDegree[i] == 0) {
//                queue.offer(i);
//                colorCount[i][colors.charAt(i) - 'a'] = 1; // Set initial color count for the node's color
//            }
//        }
//
//        int processedCount = 0;
//        int maxColorValue = 0;
//
//        // BFS for Topological Sort
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//            processedCount++;
//
//            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
//                // Update color count for the neighbor
//                for (int c = 0; c < 26; c++) {
//                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c],
//                            colorCount[current][c] + (colors.charAt(neighbor) - 'a' == c ? 1 : 0));
//                }
//
//                // Decrease in-degree and enqueue if it becomes 0
//                inDegree[neighbor]--;
//                if (inDegree[neighbor] == 0) {
//                    queue.offer(neighbor);
//                }
//            }
//
//            // Update the global max color value
//            maxColorValue = Math.max(maxColorValue, Arrays.stream(colorCount[current]).max().orElse(0));
//        }
//
//        // If not all nodes were processed, there is a cycle
//        return processedCount == nodes ? maxColorValue : -1;
//    }

    public int largestPathValue(String colors, int[][] edges) {
        int nodes = colors.length();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[nodes];

        // Build the graph
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // Queue for topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // Initialize color count array
        Map<Integer, int[]> colorCount = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            colorCount.put(i, new int[26]);
        }

        int maxColorValue = 0, processedCount = 0;

        // BFS for topological sorting
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCount++;

            // Update the current node's color count
            int currentColor = colors.charAt(current) - 'a';
            colorCount.get(current)[currentColor]++;

            // Update max color value
            maxColorValue = Math.max(maxColorValue, colorCount.get(current)[currentColor]);

            // Traverse neighbors
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                for (int c = 0; c < 26; c++) {
                    colorCount.get(neighbor)[c] = Math.max(colorCount.get(neighbor)[c], colorCount.get(current)[c]);
                }

                // Decrease in-degree and enqueue if zero
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        // If not all nodes are processed, there is a cycle
        return processedCount == nodes ? maxColorValue : -1;
    }


}
