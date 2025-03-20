package Network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximalNetworkRank {
    public static void main(String[] args) {

    }

    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adjList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sizeI = adjList.get(i).size();
            for (int j = i + 1; j < n; j++) {
                int currRank = sizeI + adjList.get(j).size();

                if (adjList.get(i).contains(j)) {
                    currRank--;
                }
                ans = Math.max(ans, currRank);
            }
        }
        return ans;
    }
}
