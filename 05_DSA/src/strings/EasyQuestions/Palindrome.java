package EasyQuestions;

public class Palindrome {
    public static boolean palindrome(String string, int n) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(--n)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "apple";

        if (palindrome(string, string.length())) {
            System.out.println("Given String is palindrome");
        } else {
            System.out.println("Given String is not palindrome");
        }
    }
}
