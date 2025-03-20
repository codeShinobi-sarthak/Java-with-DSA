package StringBasics;

import java.util.ArrayList;

public class AsciiValue {
    public static void main(String[] args) {
////        printing ascii value of a char
//        char ch = 'a';
//        System.out.println((int)ch); // better option
//        System.out.println(ch + 0);// this can al;so be done

        asciiValue("abc", "");
//        System.out.println(asciiValueRet("abc", ""));
    }

    public static void asciiValue(String str, String helper) {
        if (str.isEmpty()){
            System.out.println(helper);
            return;
        }

        char ch = str.charAt(0);
//        System.out.println((int)ch);

        asciiValue(str.substring(1), helper + ch);
        asciiValue(str.substring(1), helper);
        asciiValue(str.substring(1), helper + (ch + 0));
    }

    static ArrayList<String> asciiValueRet(String str, String helper) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(helper);
            return list;
        }

        char ch = str.charAt(0);

        ArrayList<String> left = asciiValueRet(str.substring(1), helper + ch);
        ArrayList<String> right = asciiValueRet(str.substring(1), helper);
        ArrayList<String> ascii = asciiValueRet(str.substring(1), helper + (ch+0));

        left.addAll(right);
        left.addAll(ascii);

        return left;
    }
}
