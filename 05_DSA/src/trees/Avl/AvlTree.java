package Avl;

public class AvlTree {
    static class Node {
        int val;
        Node left, right;
        int height;

        public Node(int val) {
            this.val = val;
        }
    }


    public Node root; // Root node of the tree


    //* Constructor (empty tree)
    public AvlTree() {
        this.root = null;
    }

    private int checkBalance(Node left, Node right) {
        if (left == null && right == null) return 0;
        return height(left) - height(right);
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        Node t2 = x.left;

//        rotate
        x.left = node;
        node.right = t2;

//        update height
        node.height = 1 + Math.max(height(node.left), height(node.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        Node t2 = x.right;

//        rotate
        x.right = node;
        node.left = t2;

//        update height
        node.height = 1 + Math.max(height(node.left), height(node.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
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

        int balanceFactor = checkBalance(node.left, node.right);

        if (balanceFactor > 1 && val < node.left.val) {
            return rotateRight(node);
        }
        if (balanceFactor > 1 && val > node.left.val) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balanceFactor < -1 && val < node.right.val) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        if (balanceFactor < -1 && val > node.right.val) {
            return rotateLeft(node);
        }
        return node;
    }


    public int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public void preOrderTransversal(Node node) {
        if (node == null) return;
        System.out.print(node.val + " -> ");
        preOrderTransversal(node.left);
        preOrderTransversal(node.right);
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
