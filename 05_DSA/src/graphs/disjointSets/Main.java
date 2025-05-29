package graphs.disjointSets;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create DSU for 7 elements (0 to 6)
        DisjointSets dsu = new DisjointSets(7);

        // Step 2: Perform some unions
        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(4, 5);
        dsu.union(1, 2); // Connects 0-1-2-3

        // Step 3: Find representatives
        System.out.println("Find(1): " + dsu.find(1)); // Should give root of component containing 1
        System.out.println("Find(5): " + dsu.find(5)); // Should give root of component containing 5
        System.out.println("Find(6): " + dsu.find(6)); // Same root as 4 & 5


        System.out.println("Connected(0, 3): " + dsu.connected(0, 3)); // true
        System.out.println("Connected(0, 5): " + dsu.connected(0, 5)); // false

        dsu.union(3, 5); // Now all are connected

        System.out.println("Connected(0, 5): " + dsu.connected(0, 5)); // true

        // Step 5: Print internal parent & rank arrays for debugging
        dsu.printParentArray();
    }
}