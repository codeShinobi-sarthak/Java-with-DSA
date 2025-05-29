package graphs;

import graphs.ListGraph;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListGraph graph = new ListGraph(6);

        // Add edges for a directed graph
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);


        System.out.println("DFS traversal starting from vertex 5:");
        graph.dfs(5);

        System.out.println("\n\nBFS traversal starting from vertex 5:");
        graph.bfs(5);

        System.out.println("\n\nCycle detection for directed graph: " + graph.isCyclicDirected());

        System.out.println("\nTopological Sort:");
        graph.topologicalSort();

        System.out.println("\nGraph adjacency list representation:");
        graph.display();


        System.out.println("\nGraph Khan's Algorithm:");
        System.out.println("This is the in degree array: " + Arrays.toString(graph.inDegree()));
        System.out.println(Arrays.toString(graph.kahnAlgorithm()));
    }
}
