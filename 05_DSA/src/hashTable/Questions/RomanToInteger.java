package Questions;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        // Create a hashmap to store the values of Roman numerals
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int length = s.length();
        int total = 0;

        // Iterate through the string
        for (int i = 0; i < length; i++) {
            int currentValue = romanMap.get(s.charAt(i));

            // Check if there is a next character and if it's greater
            if (i < length - 1 && romanMap.get(s.charAt(i + 1)) > currentValue) {
                total -= currentValue; // Subtractive case
            } else {
                total += currentValue; // Additive case
            }
        }

        return total;
    }
}
