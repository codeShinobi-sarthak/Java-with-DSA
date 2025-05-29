package graphs.disjointSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class representing an edge between two nodes with a weight
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Sorting edges based on weight (needed for Kruskal's algorithm)
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return "(" + src + " - " + dest + " : " + weight + ")";
    }
}

//! Disjoint Set Union (Union-Find) Data Structure (alredy implemented just importing)
//class DisjointSets {
//    int[] parent, rank;
//
//    // Constructor to create and initialize disjoint sets
//    public DisjointSets(int n) {
//        parent = new int[n];
//        rank = new int[n];
//        // Initially, every element is its own parent (self-loop)
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//            rank[i] = 0; // Rank used for union by rank optimization
//        }
//    }
//
//    // Find operation with path compression
//    public int find(int x) {
//        if (parent[x] != x)
//            parent[x] = find(parent[x]); // Path Compression
//        return parent[x];
//    }
//
//    // Union operation with union by rank
//    public void union(int x, int y) {
//        int xRoot = find(x);
//        int yRoot = find(y);
//
//        if (xRoot == yRoot) return;
//
//        // Union by rank optimization
//        if (rank[xRoot] < rank[yRoot]) {
//            parent[xRoot] = yRoot;
//        } else if (rank[yRoot] < rank[xRoot]) {
//            parent[yRoot] = xRoot;
//        } else {
//            parent[yRoot] = xRoot;
//            rank[xRoot]++;
//        }
//    }
//}

public class KruskalAlgo {
    public static void main(String[] args) {
        // Create a disjoint set instance for n vertices
        DisjointSets dsu = new DisjointSets(10);

        // 🔧 Step 1: Create a list of edges
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 1));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(2, 3, 8));
        edges.add(new Edge(3, 4, 3));
        edges.add(new Edge(4, 5, 7));
        edges.add(new Edge(5, 6, 6));
//        edges.add(new Edge(6, 7, 4));
        edges.add(new Edge(7, 8, 2));
        edges.add(new Edge(8, 9, 9));
        edges.add(new Edge(0, 9, 10));

        // 🌀 Step 2: Sort edges based on weight
        Collections.sort(edges);

        // Step 3: Iterate over the sorted edges and pick the ones
        // that don’t form a cycle (using DSU)

        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int currSrc = edge.src;
            int currDest = edge.dest;
            int currWeight = edge.weight;

            // ✅ Only add the edge if it connects two different components
            if (dsu.find(currSrc) != dsu.find(currDest)) {
                dsu.union(currSrc, currDest);
                System.out.println("Edge added: " + currSrc + " - " + currDest + " with weight " + currWeight);
                mst.add(new Edge(currSrc, currDest, currWeight));
            }
        }


        System.out.println("""
                ----------------------------------------------------------
                \nThis is the final list for MST :""");
        System.out.println(mst.toString());
    }
}
