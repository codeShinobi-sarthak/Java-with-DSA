import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue; // Ignore empty and current directory
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Move one directory up
                }
            } else {
                stack.push(part); // Push valid directory names
            }
        }

        return "/" + String.join("/", stack);
    }
}
