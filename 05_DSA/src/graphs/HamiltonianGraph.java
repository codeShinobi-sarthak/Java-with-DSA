package graphs;

import java.util.*;

public class HamiltonianGraph {

    private final int V; // Number of vertices
    private final List<List<Integer>> adjList;

    // Constructor
    public HamiltonianGraph(int vertices) {
        this.V = vertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add undirected edge
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // Print path
    public void printPath(List<Integer> path, boolean isCycle) {
        if (isCycle) {
            System.out.print("Hamiltonian Cycle: ");
        } else {
            System.out.print("Hamiltonian Path: ");
        }
        for (int node : path) {
            System.out.print(node + " ");
        }
        if (isCycle) System.out.print(path.get(0)); // to complete the cycle
        System.out.println();
    }

    public boolean findHamiltonian(int at, List<Integer> path, boolean[] visited, int start, boolean isCycle) {
        path.add(at);
        visited[at] = true;

        if (path.size() == V) {
            if (!isCycle) {
                return true;
            } else {
                // Check if there's an edge back to start to form a cycle
                return adjList.get(at).contains(start);
            }
        }

        for (int neighbor : adjList.get(at)) {
            if (!visited[neighbor]) {
                if (findHamiltonian(neighbor, path, visited, start, isCycle)) {
                    return true;
                }
            }
        }

        // Backtrack
        visited[at] = false;
        path.remove(path.size() - 1);
        return false;
    }

    // Solve for Path or Cycle
    public void solve(boolean isCycle) {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int start = 0; start < V; start++) {
            Arrays.fill(visited, false);

            if (findHamiltonian(start, path, visited, start, isCycle)) {
                printPath(path, isCycle);
                return;
            }
        }

        System.out.println(isCycle ? "No Hamiltonian Cycle found" : "No Hamiltonian Path found");
    }

    // Main
    public static void main(String[] args) {
        HamiltonianGraph g = new HamiltonianGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 0); // add this to make cycle possible

        System.out.println("---- Hamiltonian Path ----");
        g.solve(false); // false for Path

        System.out.println("---- Hamiltonian Cycle ----");
        g.solve(true);  // true for Cycle
    }
}
