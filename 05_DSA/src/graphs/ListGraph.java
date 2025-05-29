package graphs;

import java.util.*;

public class ListGraph {
    private List<List<Integer>> adjacencyList;
    private int vertexCount;

    // Constructor to initialize the graph
    public ListGraph(int vertices) {
        if (vertices <= 0) {
            throw new IllegalArgumentException("Number of vertices must be greater than 0.");
        }
        this.vertexCount = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>()); // Create an empty list for each vertex
        }
    }

    // Method to add an edge between two vertices in a directed graph
    public void addEdge(int source, int destination) {
        if (source >= vertexCount || destination >= vertexCount || source < 0 || destination < 0) {
            throw new IllegalArgumentException("Invalid vertex number");
        }
        adjacencyList.get(source).add(destination);
    }

    // Depth First Search (DFS)
    public void dfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        dfsHelper(start, visited);
    }

    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " -> ");

        // Visit all neighbors recursively
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Breadth First Search (BFS)
    public void bfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " -> ");

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    // Method to check if an undirected graph contains a cycle
    public boolean isCyclicUndirected() {
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                if (isCyclicUndirectedHelper(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUndirectedHelper(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                if (isCyclicUndirectedHelper(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle found
            }
        }
        return false;
    }

    // Method to check if a directed graph contains a cycle
    public boolean isCyclicDirected() {
        boolean[] visited = new boolean[vertexCount];
        boolean[] recursionStack = new boolean[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            if (isCyclicDirectedHelper(i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicDirectedHelper(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex]) {
            return true; // Cycle detected
        }
        if (visited[vertex]) {
            return false; // Already visited node
        }

        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int neighbor : adjacencyList.get(vertex)) {
            if (isCyclicDirectedHelper(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[vertex] = false; // Remove vertex from recursion stack
        return false;
    }

    // Topological Sort (for Directed Acyclic Graphs)
    public void topologicalSort() {
        boolean[] visited = new boolean[vertexCount];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                topologicalSortHelper(i, visited, stack);
            }
        }

        // Print topological sort (reverse post-order of DFS)
        System.out.print("Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void topologicalSortHelper(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                topologicalSortHelper(neighbor, visited, stack);
            }
        }

        stack.push(vertex); // Add vertex after exploring all its neighbors
    }


    //    FINDING IN-DEGREE OF A GRAPH
    public int[] inDegree() {
        int[] inDegree = new int[vertexCount];

        for (List<Integer> list : adjacencyList) {
            for (int neighbour : list) inDegree[neighbour]++;
        }

        return inDegree;
    }

    public int[] kahnAlgorithm() {
        int[] result = new int[vertexCount];
        int[] inDegree = inDegree(); // Calculate the in-degrees for all vertices
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue all vertices with in-degree 0
        for (int i = 0; i < vertexCount; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0; // To keep track of the result array's position

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node; // Add node to the topological sort result

            // Decrease the in-degree of all the node's neighbors
            for (int neighbor : adjacencyList.get(node)) {
                inDegree[neighbor]--;
                // If in-degree of neighbor becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If index is not equal to the number of vertices, a cycle is detected
        if (index != vertexCount) {
            System.out.println("Graph contains a cycle! Topological sort not possible.");
            return new int[0]; // Return an empty array in case of a cycle
        }

        return result; // Return the topologically sorted order
    }


    // Method to display the adjacency list representation of the graph
    public void display() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer neighbor : adjacencyList.get(i)) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }
}
