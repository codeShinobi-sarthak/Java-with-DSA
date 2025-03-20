package EasyQuestions;

public class SkipString {
    public static void main(String[] args) {

        System.out.println(skipString("twinkle twinkle little stars ", "little"));
        System.out.println(skipString2("bfhuwlittlefe", "little"));
    }


//    my own logic
    private static String skipString(String str, String target) {
        if (str.isEmpty()) {
            return "";
        }

        if (target.charAt(0) == str.charAt(0)) {
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) != str.charAt(i)) {
                    return str.charAt(0) + skipString(str.substring(1), target);
                }
            }
            return skipString(str.substring(target.length()), target);
        } else {
            return str.charAt(0) + skipString(str.substring(1), target);
        }
    }

//    other approach
    private static String skipString2(String str, String target) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.startsWith(target)){
            return skipString2(str.substring(target.length()), target);
        } else return str.charAt(0) + skipString2(str.substring(1), target);
    }
}
