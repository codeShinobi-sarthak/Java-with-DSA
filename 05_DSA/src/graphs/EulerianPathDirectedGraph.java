package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EulerianPathDirectedGraph {
    private List<List<Integer>> adjacencyList;
    private int[] inDegree;
    private int[] outDegree;
    private int vertexCount;
    private LinkedList<Integer> path;

    public static void main(String[] args) {
        // You can test here later
        EulerianPathDirectedGraph graph = new EulerianPathDirectedGraph(7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);

        graph.HierholzerAlgorithm();
        // Outputs path: [1, 3, 5, 6, 3, 2, 4, 3, 1, 2, 2, 4, 6]
    }

    // ✅ Constructor to initialize the graph
    public EulerianPathDirectedGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjacencyList = new ArrayList<>();
        this.inDegree = new int[vertexCount];
        this.outDegree = new int[vertexCount];
        this.path = new LinkedList<>();

        for (int i = 0; i < vertexCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // ✅ Add a directed edge from u to v
    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
    }

    // ✅ Calculate in-degree and out-degree for each node
    private void calculateDegree() {
        for (int u = 0; u < vertexCount; u++) {
            for (int v : adjacencyList.get(u)) {
                outDegree[u]++;
                inDegree[v]++;
            }
        }
    }

    // ✅ Check if Eulerian Path exists (directed graph logic)
    private boolean checkEulerianPath() {
        int startNodes = 0, endNodes = 0;

        for (int i = 0; i < vertexCount; i++) {
            if (outDegree[i] - inDegree[i] == 1) {
                startNodes++;
            } else if (inDegree[i] - outDegree[i] == 1) {
                endNodes++;
            } else if (inDegree[i] != outDegree[i]) {
                return false;
            }
        }

        return (startNodes == 1 && endNodes == 1) || (startNodes == 0 && endNodes == 0);
    }

    // Placeholder for main algorithm
    public void HierholzerAlgorithm() {
        calculateDegree();

        if (!checkEulerianPath()) {
            System.out.println("❌ No Eulerian Path exists in this graph.");
            return;
        }

        dfs(findStartNode());
        printPath();
    }

    // Placeholder: DFS traversal logic for path construction
    private void dfs(int at) {
        while (outDegree[at] != 0) {
            int next = adjacencyList.get(at).get(--outDegree[at]); // Get the last unused edge
            dfs(next); // Go deeper
        }
        path.add(at); // Add to path on backtrack
    }


    // ✅ Print the adjacency list (for debugging)
    public void printPath() {
        System.out.println("✅ Eulerian Path:");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
            if (i != 0) System.out.print(" -> ");
        }
        System.out.println();
    }

    // Optional: Find a valid start node for Hierholzer (can enhance later)
    private int findStartNode() {
        for (int i = 0; i < vertexCount; i++) {
            if (outDegree[i] - inDegree[i] == 1) return i; // Eulerian path start
        }

        for (int i = 0; i < vertexCount; i++) {
            if (outDegree[i] > 0) return i; // Any node with outgoing edge
        }

        return 0; // Default fallback
    }
}
