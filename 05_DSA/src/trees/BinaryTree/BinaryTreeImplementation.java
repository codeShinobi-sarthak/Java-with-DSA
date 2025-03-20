package BinaryTree;


class Node {
    int val;
    Node left, right;
    int height;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeImplementation {
//    public static class Node {
//        int val;
//        int height;
//        Node left;
//        Node right;
//
//        public Node(int val) {
//            this.val = val;
//            left = null;
//            right = null;
//        }
//    }

    public Node root; // Root node of the tree

    // Constructor (empty tree)

    public BinaryTreeImplementation() {
        this.root = null;
    }

    // Insert a new node (recursive)
    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }


    //    * when given sorted array, and you want to display a binary tree
    public void insertSorted(int[] arr) {
        insertSorted(arr, 0, arr.length);
    }

    private void insertSorted(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        insert(arr[mid]);
        insertSorted(arr, start, mid);
        insertSorted(arr, mid + 1, end);
    }

    //    * tree transversal
    public void preOrderTransversal(Node node) {
        if (node == null) return;
        System.out.print(node.val + " -> ");
        preOrderTransversal(node.left);
        preOrderTransversal(node.right);
    }

    public void inOrderTransversal(Node node) {
        if (node == null) return;
        inOrderTransversal(node.left);
        System.out.print(node.val + " -> ");
        inOrderTransversal(node.right);
    }

    public void postOrderTransversal(Node node) {
        if (node == null) return;
        postOrderTransversal(node.left);
        postOrderTransversal(node.right);
        System.out.print(node.val + " -> ");
    }

    public void levelOrderTransversal(Node node){
        
    }

    public int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) return;

        display(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }

        System.out.println("|-->" + node.val);
        display(node.left, level + 1);
    }
}
