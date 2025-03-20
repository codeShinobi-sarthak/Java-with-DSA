package EasyQuestions;

public class SkipChar {
    public static void main(String[] args) {
        String str = "bacda";
//        skipChar(str, "");
        System.out.println(skipChar2(str));
    }

    private static void skipChar(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        if (str.charAt(0) == 'a') {
            skipChar(str.substring(1), ans);
        }else skipChar(str.substring(1), ans + str.charAt(0));
    }

    private static String skipChar2(String str) {
        if (str.isEmpty()) {
            return "";
        }

        char chr = str.charAt(0);

        if (chr == 'a') {
            return skipChar2(str.substring(1));
        }else return chr + skipChar2(str.substring(1));
    }
}
