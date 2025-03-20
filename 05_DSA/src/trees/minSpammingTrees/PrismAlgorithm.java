import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Class to represent an edge in the graph with a destination vertex and weight
class Edge {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

// Main PrismAlgorithm class to represent a graph and contain methods for Prim's algorithm
public class PrismAlgorithm {
    private int V; // Number of vertices
    private List<List<Edge>> adjList; // Adjacency list for storing edges

    // Constructor to initialize the graph with V vertices
    public PrismAlgorithm(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph (for undirected graph)
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(u, v, weight));
        adjList.get(v).add(new Edge(u, v, weight));
    }

    // Placeholder for Prim's Algorithm method
    public void primMST() {
        // Priority queue to store edges by their weight in ascending order
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Array to track visited vertices
        boolean[] visited = new boolean[V];
        int totalCost = 0;

        // Start from vertex 0 by adding all its edges to the minHeap
        visited[0] = true;
        for (Edge edge : adjList.get(0)) {
            minHeap.add(edge);
        }

        // While there are edges in the minHeap, continue building the MST
        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            int u = currentEdge.start;
            int v = currentEdge.end;
            int w = currentEdge.weight;

            // Skip this edge if the destination vertex is already in the MST
            if (visited[v]) continue;

            // Mark the new vertex as visited and add the edge's weight to the MST total cost
            visited[v] = true;
            totalCost += w;

            // Add all edges from the newly visited vertex to the priority queue
            for (Edge edge : adjList.get(v)) {
                if (!visited[edge.end]) {
                    minHeap.add(edge);
                }
            }
        }

        // Print the total cost of the MST
        System.out.println("Cost of the Minimum Spanning Tree: " + totalCost);
    }


    public static void main(String[] args) {
        // Example to create and test the graph
        PrismAlgorithm graph = new PrismAlgorithm(5);

        // Adding edges (u, v, weight) - Example edges
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Call primMST() - Implement the function logic here as per your needs
        graph.primMST();
    }
}
