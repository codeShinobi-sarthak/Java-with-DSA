package Trie.problems;

public class TrieNode {
    TrieNode[] childrens = new TrieNode[26];
    boolean isWordEnd = false;
    int val = 0;
}
