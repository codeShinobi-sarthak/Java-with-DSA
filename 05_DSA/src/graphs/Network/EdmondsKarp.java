package graphs.Network;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EdmondsKarp extends CommonSolver {

    public EdmondsKarp(int n, int s, int t) {
        super(n, s, t); // Initializes the graph with vertices, source (s), and sink (t)
    }

    public long getMaxFlow() {
        long flow = 0;

        while (true) {
            this.visited = new boolean[this.vertices]; // Reset visited array for each BFS
            this.prev = new Edge[this.vertices]; // To store the path (used later to augment)

            long bottleneck = bfs(); // Run BFS to find shortest augmenting path

            if (bottleneck == 0) break; // No path found → done
            flow += bottleneck; // Add flow of current path to total flow

            // Backtrack through the path to update residual capacities
            int node = t;
            while (node != s) {
                Edge edge = prev[node];
                edge.augment(bottleneck); // Reduce forward cap, increase backward cap
                node = edge.from;
            }
        }

        return flow;
    }

    private long bfs() {
        long bottleneck = Long.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == t) break; // If sink reached, stop BFS

            for (Edge edge : adjList.get(node)) {
                long cap = edge.remainingCapacity();
                if (cap > 0 && !visited[edge.to]) {
                    queue.offer(edge.to);
                    visited[edge.to] = true;
                    prev[edge.to] = edge; // Track the path via `prev`
                }
            }
        }

        // If sink not reached → no augmenting path
        if (!visited[t]) return 0;

        // Find bottleneck capacity along the path (min residual cap in path)
        int node = t;
        while (node != s) {
            Edge edge = prev[node];
            bottleneck = Math.min(bottleneck, edge.remainingCapacity());
            node = edge.from;
        }

        printPath();

        return bottleneck;
    }

    void printPath() {
        System.out.print("Path: ");
        int node = t;
        while (node != s) {
            System.out.print(node + " <- ");
            node = prev[node].from;
        }
        System.out.println(s);

    }

    /* Example */
    public static void main(String[] args) {
        testSmallFlowGraph();
    }

    // Testing graph from:
    // http://crypto.cs.mcgill.ca/~crepeau/COMP251/KeyNoteSlides/07demo-maxflowCS-C.pdf
    private static void testSmallFlowGraph() {
        int n = 6;
        int s = n - 1; // Source node index: 5
        int t = n - 2; // Sink node index: 4

        EdmondsKarp g = new EdmondsKarp(n, s, t);

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

        System.out.println("\nMax Flow: " + g.getMaxFlow()); // Should print: Max Flow: 19
        g.printGraph(); // Optional: visualize residual graph
    }
}
