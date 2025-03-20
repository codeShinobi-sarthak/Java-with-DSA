
//! 224. Basic Calculator (Hard) (leetcode)
// Given a string s representing a valid expression,
// implement a basic calculator to evaluate it, and return the result of the evaluation.
//? Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().


import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0, num = 0, sign = 1; // Start with positive sign

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');  // Building the number
            } else if (ch == '+') {
                ans += sign * num;  // Add the number with its sign
                num = 0;
                sign = 1;           // Update sign to positive
            } else if (ch == '-') {
                ans += sign * num;
                num = 0;
                sign = -1;          // Update sign to negative
            } else if (ch == '(') {
                stack.push(ans);    // Save the current result
                stack.push(sign);   // Save the current sign
                ans = 0;            // Reset for new calculation
                sign = 1;
            } else if (ch == ')') {
                ans += sign * num;
                num = 0;
                ans *= stack.pop(); // Apply the sign before '('
                ans += stack.pop(); // Add the result before '('
            }
        }
        ans += sign * num; // Add any remaining number
        return ans;
    }

}
