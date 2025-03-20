import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjansAlgorithm {

    public List<List<Integer>> graph;
    private int nodes;
    private int id = 0;
    private List<List<Integer>> sccs = new ArrayList<>();

    public TarjansAlgorithm(int nodes) {
        this.nodes = nodes;
        this.graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        graph.get(src).add(dest);
    }

    public void tarjans() {
        int[] ids = new int[nodes];
        Arrays.fill(ids, -1);
        int[] low = new int[nodes];
        boolean[] onStack = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nodes; i++) {
            if (ids[i] == -1) {
                dfs(i, ids, low, stack, onStack);
            }
        }
        printSCCs();
    }

    private void dfs(int at, int[] ids, int[] low, Stack<Integer> stack, boolean[] onStack) {
        ids[at] = low[at] = id++;
        stack.push(at);
        onStack[at] = true;

        for (int neighbor : graph.get(at)) {
            if (ids[neighbor] == -1) {
                dfs(neighbor, ids, low, stack, onStack);
                low[at] = Math.min(low[at], low[neighbor]);
            } else if (onStack[neighbor]) {
                low[at] = Math.min(low[at], ids[neighbor]);
            }
        }

        if (ids[at] == low[at]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);
                if (node == at) break;
            }
            sccs.add(scc);
        }
    }

    private void printSCCs() {
        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }

    public static void main(String[] args) {
        TarjansAlgorithm graph = new TarjansAlgorithm(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        graph.tarjans();
    }
}
