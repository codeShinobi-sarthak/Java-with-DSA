public class SimilarStringGroups {
    public static void main(String[] args) {

    }

    int[] parent;
    int[] rank;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        rank = new int[n];

        // Initialize Union-Find structure
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Union operation for similar strings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }

        // Count unique groups
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                count++;
            }
        }

        return count;
    }

    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }
        return true;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}



