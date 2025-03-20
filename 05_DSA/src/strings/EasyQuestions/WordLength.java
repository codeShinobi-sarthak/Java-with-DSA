package EasyQuestions;

public class WordLength {
    public static void main(String[] args) {
        String str = "hello world";

        System.out.println(lengthOfLastWord(str));
    }
    
    public static int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        int count = 0;

        while (s.charAt(len) == ' ' && len >= 0) {
            len--;
        }
        while (len >= 0 && s.charAt(len) != ' ') {
            count++;
            len--;
        }
        return count;
    }
}
