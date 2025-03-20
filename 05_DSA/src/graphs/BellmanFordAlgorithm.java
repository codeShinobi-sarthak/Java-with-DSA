import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {

    static class Edge {
        int start, dest, weight;

        public Edge(int start, int dest, int weight) {
            this.start = start;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private int vertices;
    private List<List<Edge>> adjList;

    public BellmanFordAlgorithm(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
    }

    public void bellmanFord(int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < vertices ; i++) {  // Correct number of iterations
            for (int u = 0; u < vertices; u++) { 
                for (Edge edge : adjList.get(u)) {
                    int v = edge.dest;
                    int w = edge.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        for (int u = 0; u < vertices; u++) {
            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int w = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                    System.out.println("Graph contains a negative-weight cycle");
                    return;
                }
            }
        }

        printSolution(dist, src);
    }

    private void printSolution(int[] dist, int src) {
        System.out.println("Distances from source " + src + " to each vertex:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " distance: " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm g = new BellmanFordAlgorithm(5);

        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 1, 6);
        g.addEdge(3, 2, 2);

        g.bellmanFord(0);
    }
}