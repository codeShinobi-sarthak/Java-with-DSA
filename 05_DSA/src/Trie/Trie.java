package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); // start from empty root
    }

    // INSERT
    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;

    }

    // SEARCH
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    // STARTSWITH (prefix check)
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    // DELETE function wrapper
    public void delete(String word) {
        delete(root, word, 0);
    }

    // Recursive DELETE helper
    private boolean delete(TrieNode node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            if (!node.isEndOfWord) return false;

            node.isEndOfWord = false;

            // Check if node has any children
            return isNodeEmpty(node);
        }

        int idx = word.charAt(depth) - 'a';
        if (delete(node.children[idx], word, depth + 1)) {
            node.children[idx] = null;

            // Return true if current node is not end of another word and has no children
            return !node.isEndOfWord && isNodeEmpty(node);
        }

        return false;
    }

    private boolean isNodeEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) return false;
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26]; // For lowercase English letters
    boolean isEndOfWord = false; // true if node marks end of a word
}

