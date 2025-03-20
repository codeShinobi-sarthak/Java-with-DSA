package SegmentTrees;

public class SegmentTree {

    public Node root;

    class Node {
        int val;

        int startInterval, endInterval;
        Node left, right;

        public Node(int val, int startInterval, int endInterval) {
            this.val = val;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public SegmentTree(int[] arr) {
        this.root = build(arr, 0, (arr.length - 1));
    }

    private Node build(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start], start, end);
        }

        Node node = new Node(0, start, end);

        int mid = (start + end) / 2;
        node.left = build(arr, start, mid);
        node.right = build(arr, mid + 1, end);

        node.val = node.left.val + node.right.val;
        return node;
    }

    public void update(int index, int val) {
        if (index < 0 || index > root.endInterval) return;
        this.root.val = update(this.root, index, val);
    }

    private int update(Node node, int index, int val) {
        if (index < node.startInterval || index > node.endInterval) return node.val;
        if (node.startInterval == index && node.endInterval == index) {
            node.val = val;
            return node.val;
        } else {

            int leftVal = update(node.left, index, val);
            int rightVal = update(node.right, index, val);

            node.val = leftVal + rightVal;
            return node.val;
        }
    }

    public int query(int start, int end) {
        return query(this.root, start, end);
    }

    private int query(Node node, int start, int end) {
        if (node.startInterval >= start && node.endInterval <= end) {
            return node.val;
        } else if (node.startInterval > end || node.endInterval < start) {
            return 0;
        } else {
            return query(node.left, start, end) + query(node.right, start, end);
        }
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
