package graphs.Network;

public class FordFulkerson extends CommonSolver {
    // Constructor
    public FordFulkerson(int n, int s, int t) {
        super(n, s, t);
    }

    // Depth-First Search to find augmenting path
    public long dfs(int node, int t, long flow) {
        if (node == t) return flow; // Reached sink

        visited[node] = true;

        for (Edge edge : adjList.get(node)) {
            // Explore edge only if there's residual capacity and the node hasn't been visited
            if (edge.remainingCapacity() > 0 && !visited[edge.to]) {
                // Recurse with min flow
                long bottleNeck = dfs(edge.to, t, Math.min(flow, edge.remainingCapacity()));

                // If bottleneck > 0, augment the flow and return
                if (bottleNeck > 0) {
                    edge.augment(bottleNeck); // Update flow along edge and residual
                    return bottleNeck;
                }
            }
        }

        return 0; // No augmenting path found
    }

    // Ford-Fulkerson Main Loop
    public long getMaxFlow() {
        long flow = 0;

        while (true) {
            visited = new boolean[vertices]; // Reset visited for each DFS

            // Try to find an augmenting path from s to t
            long bottleNeck = dfs(s, t, Long.MAX_VALUE);

            if (bottleNeck == 0) break; // No more augmenting path → max flow found
            flow += bottleNeck;        // Add bottleneck flow to total flow
        }

        return flow;
    }

    // ===========================
    // TEST CASES
    // ===========================

    public static void main(String[] args) {
        System.out.println("Example 1:");
        example1();

        System.out.println("\n-----------------------\n");

        System.out.println("Example 2:");
        example2();
    }

    // Small Test Case
    private static void example1() {
        int n = 6;
        int s = n - 2; // Source = 4
        int t = n - 1; // Sink = 5

        FordFulkerson g = new FordFulkerson(n, s, t);

        // Source edges
        g.addEdge(s, 0, 10);
        g.addEdge(s, 1, 10);

        // Sink edges
        g.addEdge(2, t, 10);
        g.addEdge(3, t, 10);

        // Middle edges
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(0, 3, 8);
        g.addEdge(1, 3, 9);
        g.addEdge(3, 2, 6);

        System.out.println("Max Flow: " + g.getMaxFlow());
        g.printGraph();
    }

    // Bigger Test Case
    private static void example2() {
        int n = 12;
        int s = n - 2; // Source = 10
        int t = n - 1; // Sink = 11

        FordFulkerson g = new FordFulkerson(n, s, t);

        g.addEdge(s, 1, 2);
        g.addEdge(s, 2, 1);
        g.addEdge(s, 0, 7);

        g.addEdge(0, 3, 2);
        g.addEdge(0, 4, 4);

        g.addEdge(1, 4, 5);
        g.addEdge(1, 5, 6);

        g.addEdge(2, 3, 4);
        g.addEdge(2, 7, 8);

        g.addEdge(3, 6, 7);
        g.addEdge(3, 7, 1);

        g.addEdge(4, 5, 8);
        g.addEdge(4, 8, 3);

        g.addEdge(5, 8, 3);

        g.addEdge(6, t, 1);
        g.addEdge(7, t, 3);
        g.addEdge(8, t, 4);

        System.out.println("Max Flow: " + g.getMaxFlow());
        g.printGraph();
    }
}
