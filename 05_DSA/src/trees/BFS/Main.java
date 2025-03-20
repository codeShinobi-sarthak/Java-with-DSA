package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//? Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public TreeNode root;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();


    }

    //    level order successor
    public List<List<Integer>> levelTransversal() {

        List<List<Integer>> ans = new ArrayList<>(); //? this is to store the value of nodes in 2d array
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);

            }
            ans.add(currLevel);
        }
        return ans;
    }

    public TreeNode levelSuccessor(int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            if (currNode.left != null) queue.offer(currNode.left);
            if (currNode.right != null) queue.offer(currNode.right);

            if (currNode.val == val) break;
        }
        return queue.peek();
    }
}
