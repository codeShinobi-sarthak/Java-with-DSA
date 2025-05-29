package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjansAlgorithm {

    public List<List<Integer>> graph; // Adjacency list representation of the graph
    private final int nodes; // Total number of nodes in the graph
    private int id = 0; // Used to assign unique IDs to each node during DFS
    private List<List<Integer>> sccs = new ArrayList<>(); // Stores the list of all SCCs found

    public TarjansAlgorithm(int nodes) {
        this.nodes = nodes;
        this.graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // Adds a directed edge from src to dest
    public void addEdge(int src, int dest) {
        graph.get(src).add(dest);
    }

    // Entry point for running Tarjan's algorithm
    public void tarjans() {
        int[] ids = new int[nodes]; // Stores the unique discovery ID for each node
        Arrays.fill(ids, -1); // -1 indicates the node hasn't been visited yet
        int[] low = new int[nodes]; // Lowest ID reachable from each node
        boolean[] onStack = new boolean[nodes]; // Tracks nodes currently in the DFS stack
        Stack<Integer> stack = new Stack<>(); // Stack to hold nodes for current DFS path

        for (int i = 0; i < nodes; i++) {
            if (ids[i] == -1) {
                dfs(i, ids, low, stack, onStack); // Start DFS if the node hasn't been visited
            }
        }

        printSCCs(); // Print all strongly connected components
    }

    // Recursive DFS function to find SCCs
    private void dfs(int at, int[] ids, int[] low, Stack<Integer> stack, boolean[] onStack) {
        ids[at] = low[at] = id++; // Assign discovery ID and low-link value
        stack.push(at); // Add node to the stack
        onStack[at] = true; // Mark node as being on the stack

        // Explore all neighbors of the current node
        for (int neighbor : graph.get(at)) {
            if (ids[neighbor] == -1) {
                // If neighbor hasn't been visited, recurse
                dfs(neighbor, ids, low, stack, onStack);
                low[at] = Math.min(low[at], low[neighbor]); // Update low-link value
            } else if (onStack[neighbor]) {
                // If neighbor is on the stack, it's part of the current SCC
                low[at] = Math.min(low[at], ids[neighbor]);
            }
        }

        // If current node is the start of an SCC
        if (ids[at] == low[at]) {
            List<Integer> scc = new ArrayList<>();

            // Pop nodes from stack until we reach the current node
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);
                if (node == at) break;
            }

            sccs.add(scc); // Add the SCC to the list
        }
    }

    // Utility function to print all SCCs
    private void printSCCs() {
        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }

    // Sample usage of the algorithm
    public static void main(String[] args) {
        TarjansAlgorithm graph = new TarjansAlgorithm(5);

        // Add directed edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        // Run Tarjan's algorithm
        graph.tarjans();
    }
}
