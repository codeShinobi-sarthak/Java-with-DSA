package graphs;

import java.util.*;

public class DijkstraAlgorithm {
    private int vertices; // Number of vertices
    private List<List<Node>> adjList; // Adjacency list for the graph

    // Constructor to initialize the graph with given vertices
    public DijkstraAlgorithm(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize each list for each vertex
        }
    }

    // Node class to store a vertex and weight
    static class Node {
        int vertex, weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Method to add an edge with a specific weight between two vertices
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        adjList.get(v).add(new Node(u, weight)); // For undirected graph
    }

    // Dijkstra's shortest path algorithm
    public void dijkstra(int src) {
        int[] dist = new int[vertices]; // Array to hold shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        queue.add(new Node(src, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int curr_vertex = currentNode.vertex;

            // Process each neighbor of the current node
            for (Node neighbor : adjList.get(curr_vertex)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If there's a shorter path to v through u
                if (dist[curr_vertex]  + weight< dist[v]) {
                    dist[v] = dist[curr_vertex] + weight;
                    queue.add(new Node(v, dist[v]));
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist, src);
    }

    // Helper method to print distances from the source to each vertex
    private void printSolution(int[] dist, int src) {
        System.out.println("Distances from source " + src + " to each vertex:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " distance: " + dist[i]);
        }
    }

    // Main method to test the Dijkstra algorithm
    public static void main(String[] args) {
        DijkstraAlgorithm g = new DijkstraAlgorithm(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 4);
        g.addEdge(4, 1, 3);
        g.addEdge(4, 2, 9);
        g.addEdge(4, 3, 2);

        g.dijkstra(0); // Replace 0 with any starting vertex
    }
}
