package Network;

import java.util.*;

public class LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {

    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        HashMap<Character, List<Character>> graph = new HashMap<>();

        // Step 1: Build the graph
        for (int i = 0; i < n; i++) {
            char charS1 = s1.charAt(i);
            char charS2 = s2.charAt(i);
            graph.putIfAbsent(charS1, new ArrayList<>());
            graph.putIfAbsent(charS2, new ArrayList<>());

            graph.get(charS1).add(charS2);
            graph.get(charS2).add(charS1);
        }

        StringBuilder ans = new StringBuilder();
        int m = baseStr.length();

        // Helper function to find the smallest character in the connected component
        for (int j = 0; j < m; j++) {
            char c = baseStr.charAt(j);
            char smallest = findSmallestEquivalent(graph, c, new HashSet<>());
            ans.append(smallest);
        }

        return ans.toString();
    }

    // Helper function to perform DFS and find the smallest character
    private char findSmallestEquivalent(HashMap<Character, List<Character>> graph, char current, Set<Character> visited) {
        if (visited.contains(current)) return current;

        visited.add(current);
        char smallest = current;

        if (graph.containsKey(current)) {
            for (char neighbor : graph.get(current)) {
                char candidate = findSmallestEquivalent(graph, neighbor, visited);
                if (candidate < smallest) {
                    smallest = candidate;
                }
            }
        }

        return smallest;
    }


//!   --------------------  more effective solution

    public String smallestEquivalentString2(String s1, String s2, String baseStr) {
        int[] parent = new int[26]; // To represent each character 'a' to 'z'

        // Step 1: Initialize each character to be its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Step 2: Union operation for each pair in s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            int char1 = s1.charAt(i) - 'a';
            int char2 = s2.charAt(i) - 'a';
            union(parent, char1, char2);
        }

        // Step 3: Build the result string
        StringBuilder ans = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int smallestEquivalent = find(parent, c - 'a');
            ans.append((char) (smallestEquivalent + 'a'));
        }

        return ans.toString();
    }

    // Union function to unify two characters
    private void union(int[] parent, int char1, int char2) {
        int root1 = find(parent, char1);
        int root2 = find(parent, char2);

        // Always link the larger root to the smaller root for lexicographical order
        if (root1 != root2) {
            if (root1 < root2) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }
        }
    }

    // Find function with path compression
    private int find(int[] parent, int charIndex) {
        if (parent[charIndex] != charIndex) {
            parent[charIndex] = find(parent, parent[charIndex]); // Path compression
        }
        return parent[charIndex];
    }


}
