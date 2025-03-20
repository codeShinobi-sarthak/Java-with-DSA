// You are given an array of strings equations that represent relationships between variables
// where each string equations[i] is of length 4 and takes one of two different forms:
// "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

// Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.


public class SatisfiabilityofEqualityEquations {
    public static void main(String[] args) {

    }

    class Solution {
        int[] parent = new int[26]; // Parent array for Union-Find

        public boolean equationsPossible(String[] equations) {
            // Initialize parent array
            for (int i = 0; i < 26; i++) {
                parent[i] = i; // Each variable is its own parent initially
            }

            // First pass: process all "==" equations
            for (String eq : equations) {
                if (eq.charAt(1) == '=') { // "==" equation
                    int x = eq.charAt(0) - 'a';
                    int y = eq.charAt(3) - 'a';
                    union(x, y);
                }
            }

            // Second pass: process all "!=" equations
            for (String eq : equations) {
                if (eq.charAt(1) == '!') { // "!=" equation
                    int x = eq.charAt(0) - 'a';
                    int y = eq.charAt(3) - 'a';

                    // If x and y are in the same group, the equation is invalid
                    if (find(x) == find(y)) {
                        return false;
                    }
                }
            }

            return true; // All equations are valid
        }

        // Find with path compression
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union operation
        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX; // Attach one root to the other
            }
        }
    }

}
