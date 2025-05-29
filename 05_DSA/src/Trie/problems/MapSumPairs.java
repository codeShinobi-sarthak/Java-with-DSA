package Trie.problems;

import Trie.Trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    TrieNode root;
    Map<String, Integer> map; // track original values

    public MapSumPairs() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        TrieNode node = root;

        for (char ch : key.toCharArray()) {
            int idx = ch - 'a';
            if (node.childrens[idx] == null) {
                node.childrens[idx] = new TrieNode();
            }
            node = node.childrens[idx];
            node.val += delta; // update with delta instead of full val
        }

        node.isWordEnd = true;
    }

    public int sum(String prefix) {
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.childrens[idx] == null) {
                return 0;
            }
            node = node.childrens[idx];
        }

        return node.val;
    }
}
