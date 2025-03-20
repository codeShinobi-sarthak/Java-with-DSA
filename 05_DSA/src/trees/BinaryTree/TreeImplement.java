package BinaryTree;

import java.util.Scanner;

public class TreeImplement {
    private Node root;

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }


    //    insert element
    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value for root node : ");
        int val = scanner.nextInt();
        this.root = new Node(val);
        insert(root, scanner);
    }

    private void insert(Node node, Scanner scanner) {
        System.out.print("Do you want to add to the left of " + node.val + " : ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value for left of " + node.val + " : ");
            int val = scanner.nextInt();
            node.left = new Node(val);
            insert(node.left, scanner);
        }
        System.out.print("Do you want to add to the right of " + node.val + " : ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value for right of : " + node.val + " : ");
            int val = scanner.nextInt();
            node.right = new Node(val);
            insert(node.right, scanner);
        }
    }

    public void display() {
        display(root, " ");
    }

    private void display(Node node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.val);
        display(node.left, indent);
        display(node.right, indent + " \t ");
    }

    public void littleBeautyDisplay() {
        littleBeautyDisplay(root, 0);
    }

    private void littleBeautyDisplay(Node node, int line) {
        if (node == null) return;

        littleBeautyDisplay(node.right, line + 1);

        if (line != 0) {
            for (int i = 0; i < line; i++) {
                System.out.print("\t");
            }
            System.out.println("|----> " + node.val);
        }else System.out.println(node.val);

        littleBeautyDisplay(node.left, line + 1);
    }
}