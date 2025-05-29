package trees.treeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(5, "A");
        map.put(3, "B");
        map.put(7, "C");
        map.put(2, "D");
        map.put(4, "E");

//                 (5, A)  ← (root)
//                  /   \
//             (3, B)   (7, C)
//             /  \
//        (2, D)  (4, E)
//

        System.out.println(map.get(3)); // Output: B
        System.out.println(map.get(7)); // Output: C
        System.out.println(map.get(10)); // Output: null (not found)
        map.remove(3);
        System.out.println(map.get(3)); // Output: null (removed)
    }
}
