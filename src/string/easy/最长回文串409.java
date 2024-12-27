package string.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class 最长回文串409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccd"));
    }

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        boolean flag = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i]))
                map.put(chars[i], 1);
            else
                map.put(chars[i], map.get(chars[i]) + 1);
        }
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
           if ( map.get(key) % 2 == 0)
               res += map.get(key);
           else {
               res += map.get(key) - 1;
               flag = true;
           }
        }
        return flag ? res + 1 : res;
    }
}
