///**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode() {}
// * ListNode(int val) { this.val = val; }
// * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
//
////? Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//    TreeNode(int val) {
//        this.val = val;
//    }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//
//public class LinkedListinBinaryTree {
//    public static void main(String[] args) {
//
//    }
//
//    public boolean isSubPath(ListNode head, TreeNode root) {
//        if (root == null) return false;
//
//        // Check if current path starts matching
//        if (isPathMatching(head, root)) {
//            return true;
//        }
//
//        // Recurse to the left and right subtree to check other paths
//        return isSubPath(head, root.left) || isSubPath(head, root.right);
//    }
//
//    // Helper function to check if the list matches the path in the tree
//    private boolean isPathMatching(ListNode head, TreeNode root) {
//        if (head == null) return true;
//        if (root == null || head.val != root.val) return false;
//
//        return isPathMatching(head.next, root.left) || isPathMatching(head.next, root.right);
//    }
//
//
//}
