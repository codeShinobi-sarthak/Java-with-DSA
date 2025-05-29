package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {
    int vertex; // Total number of vertices
    List<List<Integer>> graph; // Original graph
    List<List<Integer>> reversedGraph; // Reversed graph
    List<List<Integer>> sccs; // Stores list of all strongly connected components

    public Kosaraju(int vertex) {
        this.vertex = vertex;
        this.graph = new ArrayList<>();
        this.reversedGraph = new ArrayList<>();
        this.sccs = new ArrayList<>();

        // Initialize both original and reversed graph with empty adjacency lists
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }
    }

    // Adds a directed edge from src to dest
    public void addEdge(int src, int dest) {
        graph.get(src).add(dest);
    }

    // Main function to perform Kosaraju's Algorithm
    public void kosarajuAlgorithm() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertex];

        // 👉 Step 1: DFS on original graph to fill stack by finish times
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                dfsOriginalGraph(i, visited, stack);
            }
        }

        // 👉 Step 2: Reverse the graph
        reverseGraph();

        // 👉 Step 3: DFS on reversed graph using stack order to find SCCs
        boolean[] reverseVisited = new boolean[vertex];

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!reverseVisited[curr]) {
                List<Integer> component = new ArrayList<>();
                dfsReversedGraph(curr, reverseVisited, component);
                sccs.add(component);
            }
        }

        // Print all strongly connected components
        printSCCs();
    }

    // DFS on original graph to fill stack
    private void dfsOriginalGraph(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfsOriginalGraph(neighbour, visited, stack);
            }
        }

        stack.push(node); // Push to stack after all neighbours are visited
    }

    // DFS on reversed graph to collect nodes of a single SCC
    private void dfsReversedGraph(int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbour : reversedGraph.get(node)) {
            if (!visited[neighbour]) {
                dfsReversedGraph(neighbour, visited, component);
            }
        }
    }

    // Reverse the direction of all edges in the original graph
    private void reverseGraph() {
        for (int i = 0; i < vertex; i++) {
            for (int neighbor : graph.get(i)) {
                reversedGraph.get(neighbor).add(i); // Reverse the edge
            }
        }
    }

    // Print all SCCs
    private void printSCCs() {
        System.out.println("🔍 Strongly Connected Components (SCCs):");
        int index = 1;
        for (List<Integer> component : sccs) {
            System.out.println("SCC " + index + ": " + component);
            index++;
        }
    }

    // Test the implementation
    public static void main(String[] args) {
        Kosaraju g = new Kosaraju(5);

        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.kosarajuAlgorithm();
    }
}
