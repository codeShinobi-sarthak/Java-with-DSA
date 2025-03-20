public class Main {
    public static void main(String[] args) {
        DisjointSets ds = new DisjointSets(5); // Create 5 elements {0, 1, 2, 3, 4}

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.printParentArray(); // Check parent and rank arrays

        System.out.println("Find(2): " + ds.find(2)); // Should point to the root of 0,1,2
        System.out.println("Find(3): " + ds.find(3)); // Should point to the root of 3,4
    }
}