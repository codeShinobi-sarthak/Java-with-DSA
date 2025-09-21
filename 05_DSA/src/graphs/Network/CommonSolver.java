package graphs.Network;

import java.util.ArrayList;
import java.util.List;

public class CommonSolver {
    List<List<Edge>> adjList; // Adjacency list to store edges
    int vertices;             // Total number of vertices
    boolean[] visited;        // Visited array
    int s, t;
    Edge[] prev;


    public CommonSolver(int n, int s, int t) {
        this.s = s;
        this.t = t;
        this.adjList = new ArrayList<>();
        this.vertices = n;
        this.visited = new boolean[n];

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }


    public void addEdge(int from, int to, int capacity) {
        Edge forward = new Edge(from, to, capacity);       // Real edge
        Edge backward = new Edge(to, from, 0);             // Residual edge

        // Linking them as residuals of each other
        forward.residual = backward;
        backward.residual = forward;

        adjList.get(from).add(forward);
        adjList.get(to).add(backward);
    }

    // Prints the flow through each non-residual edge
    void printGraph() {
        System.out.println("\n=== Flow Network ===");
        for (int i = 0; i < vertices; i++) {
            for (Edge e : adjList.get(i)) {
                if (!e.isResidual()) {
                    System.out.println(e); // Uses Edge's toString
                }
            }
        }
    }
}
