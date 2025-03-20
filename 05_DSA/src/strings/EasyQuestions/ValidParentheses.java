package EasyQuestions;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "(){}";
        String str1 = "){}";
        String str2 = "(})]";

        System.out.println(isValid(str));
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
    }

    public static boolean isValid(String s) {
        int len = s.length();

        for (int i = 0; i < len; i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                if (s.charAt(i + 1) != ')') return false;
                i++;
            } else if (ch == '{') {
                if (s.charAt(i + 1) != '}') return false;
                i++;
            } else if (ch == '[') {
                if (s.charAt(i + 1) != ']') return false;
                i++;
            } else return false;
        }

        return true;
    }

}
