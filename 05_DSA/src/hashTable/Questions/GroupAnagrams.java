package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str_s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str_s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sortString(str);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
