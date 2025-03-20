import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int w = words.length;
        int index = 0;

        // Process each line until all words are justified
        while (index < w) {
            // Determine the last word that fits on the current line and the total length of words
            int[] endAndLength = currentEndIndex(index, words, maxWidth, w);
            int currentEnd = endAndLength[0]; // Index of the word after the last word for this line
            int totalLength = endAndLength[1]; // Total length of words in this line (excluding spaces)

            // Justify the current line and add it to the result
            result.add(justify(index, currentEnd - 1, words, totalLength, maxWidth));
            index = currentEnd; // Move to the next set of words
        }

        return result;
    }

    /**
     * Justifies a single line of text.
     *
     * @param currStart   The index of the first word in the line
     * @param currEnd     The index of the last word in the line
     * @param words       The array of words
     * @param totalLength The total length of all words in the line (excluding spaces)
     * @param maxWidth    The maximum width of the line
     * @return The fully justified line as a String
     */
    private String justify(int currStart, int currEnd, String[] words, int totalLength, int maxWidth) {
        StringBuilder s = new StringBuilder();
        int wordCount = currEnd - currStart + 1; // Number of words in the line

        // Handle the last line or a single-word line
        if (currEnd == words.length - 1 || wordCount == 1) {
            // Left-align the line: Add all words and pad spaces at the end
            for (int i = currStart; i <= currEnd; i++) {
                s.append(words[i]);
                if (i < currEnd) {
                    s.append(" "); // Add a space between words
                }
            }
            while (s.length() < maxWidth) {
                s.append(" "); // Add spaces to reach maxWidth
            }
            return s.toString();
        }

        // Calculate spaces for fully justified lines
        int totalSpaces = maxWidth - totalLength; // Total spaces to distribute
        int gaps = wordCount - 1; // Number of gaps between words
        int spaceBetween = totalSpaces / gaps; // Minimum spaces per gap
        int extraSpaces = totalSpaces % gaps; // Remaining spaces to distribute

        // Add words and distribute spaces
        for (int i = currStart; i <= currEnd; i++) {
            s.append(words[i]); // Append the word
            if (i < currEnd) { // If not the last word
                // Add the minimum spaces between words
                for (int j = 0; j < spaceBetween; j++) {
                    s.append(" ");
                }
                // Distribute extra spaces to the first few gaps
                if (extraSpaces-- > 0) {
                    s.append(" ");
                }
            }
        }

        return s.toString();
    }

    /**
     * Determines the end index of the current line and the total length of words.
     *
     * @param index    The starting index of the current line
     * @param words    The array of words
     * @param maxWidth The maximum width of a line
     * @param w        The total number of words
     * @return An array with two values: [end index of the line, total length of words]
     */
    private int[] currentEndIndex(int index, String[] words, int maxWidth, int w) {
        int end = index; // Pointer to determine where the line ends
        int length = 0; // Total length of words in the current line

        for (int i = index; i < w; i++) {
            // Check if adding the current word exceeds the line width
            if (length + words[i].length() + (i - index) > maxWidth) {
                break; // Stop if the line exceeds maxWidth
            } else {
                length += words[i].length(); // Add the word length
                end++; // Move the end pointer
            }
        }

        return new int[]{end, length}; // Return the end index and total length
    }
}


