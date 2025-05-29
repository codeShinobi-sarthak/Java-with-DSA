package graphs.disjointSets;

import java.util.Arrays;

public class DisjointSets {

    private final int size;
    private int componentCount;

    // Parent array to track the root of each set
    private final int[] parent;

    // Rank array to keep trees shallow (used in Union by Rank)
    private final int[] rank;

    // Constructor
    public DisjointSets(int size) {
        this.size = size;
        this.componentCount = size;
        this.parent = new int[size];
        this.rank = new int[size];

        // Initially each node is its own parent
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // FIND operation with PATH COMPRESSION (iterative version)
    public int find(int node) {
        int root = node;
        while (root != parent[root]) {
            root = parent[root];
        }

        // Path compression: make all nodes on the path point directly to root
        while (node != root) {
            int next = parent[node];
            parent[node] = root;
            node = next;
        }

        return root;
    }

    // Check if two nodes are in the same set
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // UNION operation with UNION BY RANK
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Attach the smaller ranked tree under the larger ranked tree
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            componentCount--; // Successfully merged, so reduce component count
        }
    }

    // Returns total size of DSU
    public int getSize() {
        return this.size;
    }

    // Returns the number of disjoint sets (components)
    public int getComponentCount() {
        return this.componentCount;
    }

    // Returns the rank (not actual component size)
    public int getRank(int node) {
        return rank[find(node)];
    }

    // Debug utility: print current parent and rank arrays
    public void printParentArray() {
        System.out.println("Parent: " + Arrays.toString(parent));
        System.out.println("Rank:   " + Arrays.toString(rank));
        System.out.println("Components: " + componentCount);
    }
}
