package SegmentTrees;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree tree = new SegmentTree(arr);

        tree.update(3, 9);
        tree.display();
//        System.out.println(tree.query(2, 6));
    }
}
