package string.easy;

import java.util.HashMap;

public class 同构字符串205 {
    public static void main(String[] args) {
//        "badc"
//        "baba"
        boolean isomorphic = isIsomorphic("paper", "title");
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map1.containsKey(chars[i])) {
                map1.put(chars[i], chart[i]);
            }
            if (!map2.containsKey(chart[i])) {
                map2.put(chart[i], chars[i]);
            }
            if (map1.get(chars[i]) != chart[i]) return false;
            if (map2.get(chart[i]) != chars[i]) return false;
        }
        return true;
    }
}
