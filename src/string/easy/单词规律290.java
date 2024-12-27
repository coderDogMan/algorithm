package string.easy;

import java.util.HashMap;

public class 单词规律290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
//        System.out.println(wordPattern("abba"
//                ,"dog cat cat fish"));
//        System.out.println(wordPattern("abba","dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (s1.length != pattern.length()) return false;
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();

        for (int i = 0; i < s1.length; i++) {
            if (!map1.containsKey(s1[i]) && !map2.containsKey(chars[i])) {
                map1.put(s1[i], chars[i]);
                map2.put(chars[i], s1[i]);
            } else if (map1.containsKey(s1[i]) || map2.containsKey(chars[i])) {
                return false;
            }
            else if (map1.get(s1[i]) != chars[i] || !map2.get(chars[i]).equals(s1[i])){
                return false;
            }

        }
        return true;
    }
}
