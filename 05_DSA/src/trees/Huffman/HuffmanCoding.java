package Huffman;

import java.util.*;

// HuffmanCoding class
public class HuffmanCoding {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        char character;
        int cost;
        Node left;
        Node right;

        // Constructor for leaf nodes
        public Node(Character data, int cost) {
            this.character = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        // Constructor for internal nodes
        public Node(int cost, Node left, Node right) {
            this.character = '\0'; // Placeholder for internal nodes
            this.cost = cost;
            this.left = left;
            this.right = right;
        }

        // Implement compareTo method for priority queue
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    private HashMap<Character, Integer> calculateFrequencies(String input) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        return frequencyMap;
    }

    private PriorityQueue<Node> buildPriorityQueue(HashMap<Character, Integer> frequencyMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        return pq;
    }

    private Node buildHuffmanTree(PriorityQueue<Node> pq) {
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.cost + right.cost, left, right);
            pq.add(parent);
        }

        return pq.poll(); // The root of the Huffman Tree
    }

    private void generateCodes(Node root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null){
            encoder.put(root.character, code);
            decoder.put(code, root.character);
        }

        // Recur for left and right subtrees
        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public void encode(String input) {
        encoder = new HashMap<>();
        decoder = new HashMap<>();

        // Step 1: Calculate frequencies
        HashMap<Character, Integer> frequencyMap = calculateFrequencies(input);

        // Step 2: Build priority queue
        PriorityQueue<Node> pq = buildPriorityQueue(frequencyMap);

        // Step 3: Build the Huffman Tree
        Node root = buildHuffmanTree(pq);

        // Step 4: Generate Huffman Codes
        generateCodes(root, "");
    }

    public String getEncodedString(String input) {
        StringBuilder encodedString = new StringBuilder();

        for (char ch : input.toCharArray()) {
            encodedString.append(encoder.get(ch));
        }

        return encodedString.toString();
    }

    public String decode(String encodedString) {
        StringBuilder decodedString = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (char ch : encodedString.toCharArray()) {
            temp.append(ch);
            if (decoder.containsKey(temp.toString())) {
                decodedString.append(decoder.get(temp.toString()));
                temp.setLength(0); // Clear the temporary string
            }
        }

        return decodedString.toString();
    }
}
