package Trie.problems;

//! Link: https://leetcode.com/problems/word-search-ii/description/


import java.util.ArrayList;
import java.util.List;

public class WordSearchTwo {


    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;  // Store word at the end node
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // Step 1: Insert all words into the Trie
        for (String word : words) {
            insertWord(word);
        }

        // Step 2: Traverse each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void insertWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.word = word; // mark complete word
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#')
            return;

        char c = board[row][col];
        TrieNode nextNode = node.children[c - 'a'];

        if (nextNode == null) return;

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // avoid duplicates
        }

        board[row][col] = '#'; // mark visited

        dfs(board, row + 1, col, nextNode, result);
        dfs(board, row - 1, col, nextNode, result);
        dfs(board, row, col + 1, nextNode, result);
        dfs(board, row, col - 1, nextNode, result);

        board[row][col] = c; // backtrack
    }


}
