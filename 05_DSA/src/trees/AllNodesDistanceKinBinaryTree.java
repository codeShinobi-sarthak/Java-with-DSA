package trees;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 * You can return the answer in any order.
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

public class AllNodesDistanceKinBinaryTree {

    // Adjacency list for graph representation
    List<Integer>[] graph = new ArrayList[501];

    public AllNodesDistanceKinBinaryTree() {
        // Initialize each element in the graph array as a new ArrayList
        for (int i = 0; i < 501; i++) {
            graph[i] = new ArrayList<>();
        }
    }

//    ? only for leatcode
//    public Solution() {
//        // Initialize each element in the graph array as a new ArrayList
//        for (int i = 0; i < 501; i++) {
//            graph[i] = new ArrayList<>();
//        }
//    }

    public void buildGraph(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int nodeVal = node.val;

            // Connect the node to its left child if it exists
            if (node.left != null) {
                int leftVal = node.left.val;
                graph[nodeVal].add(leftVal); // Parent to child
                graph[leftVal].add(nodeVal); // Child to parent
                queue.add(node.left);
            }

            // Connect the node to its right child if it exists
            if (node.right != null) {
                int rightVal = node.right.val;
                graph[nodeVal].add(rightVal); // Parent to child
                graph[rightVal].add(nodeVal); // Child to parent
                queue.add(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Build the graph representation from the tree
        buildGraph(root);

        // Implement BFS or DFS to find all nodes at distance K from the target
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[501]; // Keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);
        visited[target.val] = true;

        int distance = 0;
        while (!queue.isEmpty() && distance < k) {
            int size = queue.size(); // Number of nodes at the current level

            for (int i = 0; i < size; i++) {
                int currNode = queue.poll();

                for (int neighbor : graph[currNode]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            distance++; // Increment distance after processing all nodes at the current level
        }

// Collect all nodes that are exactly distance K from the target node
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

}
