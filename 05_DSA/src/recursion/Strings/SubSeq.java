package Strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("abc", "");
//        System.out.println(subseqList("abc", ""));
    }

    static void subseq(String str, String helper) {
        if (str.isEmpty()) {
            System.out.println(helper);
            return;
        }

        char ch = str.charAt(0);

        subseq(str.substring(1), helper + ch);
        subseq(str.substring(1), helper);
    }



    static ArrayList<String> subseqList(String str, String helper) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(helper);
            return list;
        }

        char ch = str.charAt(0);

        ArrayList<String> left = subseqList(str.substring(1), helper + ch);
        ArrayList<String> right = subseqList(str.substring(1), helper);

        left.addAll(right);

        return left;
    }
}

