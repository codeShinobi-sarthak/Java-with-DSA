import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationAllWords {
    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return ans;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        // Build the frequency map of words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                int wordIndex = i + j * wordLength;
                String word = s.substring(wordIndex, wordIndex + wordLength);

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > wordCount.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                ans.add(i);
            }
        }
        return ans;
    }
}


// * time limit exceded

//    Set<String> permutations = new HashSet<>();
//
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> ans = new LinkedList<>();
//        if (s == null || s.length() == 0 || words == null || words.length == 0) {
//            return ans;
//        }
//
//        int wordLength = words[0].length();
//        int totalLength = wordLength * words.length;
//
//        // Generate all possible permutations of words
//        boolean[] used = new boolean[words.length];
//        addPermutation(words, "", used);
//
//        // Check each substring of the correct length
//        for (int i = 0; i <= s.length() - totalLength; i++) {
//            String sub = s.substring(i, i + totalLength);
//            if (permutations.contains(sub)) {
//                ans.add(i);
//            }
//        }
//
//        return ans;
//    }
//
//    // Helper method to generate all permutations
//    private void addPermutation(String[] words, String current, boolean[] used) {
//        if (current.length() == words.length * words[0].length()) {
//            permutations.add(current);
//            return;
//        }
//
//        for (int i = 0; i < words.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                addPermutation(words, current + words[i], used);
//                used[i] = false;
//            }
//        }
//    }

