package Strings;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        printPermute("abcd", "");
        System.out.println(printPermuteArray("abcd", ""));
        System.out.println("No of permutations are: " + printPermuteCount("abcd" , ""));
    }

    public static void printPermute(String str, String permute) {
        if (str.isEmpty()) {
            System.out.println(permute);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring((i + 1));
            printPermute(newStr, permute + currChar);
        }
    }

    public static ArrayList<String> printPermuteArray(String str, String permute) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(permute);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring((i + 1));
            ans.addAll(printPermuteArray(newStr, permute + currChar));
        }
        return ans;
    }

    public static int printPermuteCount(String str, String permute) {
        if (str.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring((i + 1));
            count += printPermuteCount(newStr, permute + currChar);
        }
        return count;
    }
}
