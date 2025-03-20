import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumNumberVerticesReachAllNodes {
    public static void main(String[] args) {

    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adjList = new LinkedList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
        }

        // Find vertices with no incoming edges
        boolean[] hasIncomingEdge = new boolean[n];
        for (List<Integer> edge : edges) {
            hasIncomingEdge[edge.get(1)] = true;
        }

        // Collect vertices with no incoming edges
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIncomingEdge[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

}
