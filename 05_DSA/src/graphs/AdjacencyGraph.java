package graphs;

public class AdjacencyGraph {
    private int[][] adjacencyMatrix;
    private int vertexCount;
    // Initial capacity for the graph
    private int capacity;

    public AdjacencyGraph(int capacity) {
        adjacencyMatrix = new int[capacity][capacity];
        this.capacity = capacity;
        this.vertexCount = 0;
    }

    public void addVertex() {
        if (vertexCount == adjacencyMatrix.length) {
            resizeMatrix();
        }
        vertexCount++;
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1; // For unweighted graphs
        // For weighted graphs, you can set it to the weight value instead
    }

    // Resize the adjacency matrix
    private void resizeMatrix() {
        capacity = adjacencyMatrix.length * 2;
        int[][] newMatrix = new int[capacity][capacity];

        // Copy existing values to the new matrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, newMatrix[i], 0, adjacencyMatrix.length);
        }

        adjacencyMatrix = newMatrix;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.println(i + " -> " + j);
                }
            }
        }
    }
}
