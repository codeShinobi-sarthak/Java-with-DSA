package graphs.Questons;

import java.util.*;

public class MostProfitablePathTree {
    public static void main(String[] args) {


    }

    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> adjList = new ArrayList<>();
    private int maxIncome = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        visited = new boolean[n];
        bobPath = new HashMap<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new LinkedList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Find Bob's path timing
        findBobPath(bob, 0);

        // Reset visited array for Alice's DFS
        Arrays.fill(visited, false);

        // Find Alice's maximum profitable path
        findAlicePath(0, 0, 0, amount);

        return maxIncome;
    }

    private void findAlicePath(int sourceNode, int time, int income, int[] amount) {
        visited[sourceNode] = true;

        // Calculate profit
        if (!bobPath.containsKey(sourceNode) || time < bobPath.get(sourceNode)) {
            income += amount[sourceNode]; // Full profit
        } else if (time == bobPath.get(sourceNode)) {
            income += amount[sourceNode] / 2; // Half profit
        }

        boolean isLeaf = true;

        for (int adjacentNode : adjList.get(sourceNode)) {
            if (!visited[adjacentNode]) {
                isLeaf = false;
                findAlicePath(adjacentNode, time + 1, income, amount);
            }
        }

        // If leaf node, update maxIncome
        if (isLeaf) {
            maxIncome = Math.max(maxIncome, income);
        }
    }

    private boolean findBobPath(int sourceNode, int time) {
        bobPath.put(sourceNode, time);
        visited[sourceNode] = true;

        if (sourceNode == 0) return true; // Bob reaches root

        for (int adjacentNode : adjList.get(sourceNode)) {
            if (!visited[adjacentNode] && findBobPath(adjacentNode, time + 1)) {
                return true;
            }
        }

        bobPath.remove(sourceNode);
        return false;
    }
}
