public class FloydWarshall {

    final static int INF = 99999; // Represents infinity for unreachable paths

    // Method to implement the Floyd-Warshall algorithm
    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }

        // Pseudocode for Floyd-Warshall algorithm:
        /*
           for each vertex k:
               for each vertex i:
                   for each vertex j:
                       if dist[i][k] + dist[k][j] < dist[i][j]:
                           dist[i][j] = dist[i][k] + dist[k][j]
        */


        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] > (dist[i][k] + dist[k][j])) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    // Method to print the solution matrix
    public static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    // Main method to test the Floyd-Warshall algorithm
    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, INF, 5},
                {2, 0, INF, 4},
                {INF, 1, 0, INF},
                {INF, INF, 2, 0}
        };

        FloydWarshall.floydWarshall(graph);
    }
}
