package other.mid;

import java.util.HashMap;
import java.util.Set;

public class 剑指OfferII014字符串中的变位词 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> wind = new HashMap<Character, Integer>();
        for (char c : s1.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        int size = s1.length();
        int len = 0;
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            char key = s2.charAt(i);
            wind.put(key, wind.getOrDefault(key, 0) + 1);
            len++;
            if (len == size) {
                if (contains(wind, need)) {
                    return true;
                }
                char removeKey = s2.charAt(left);
                if (wind.get(removeKey) > 1) {
                    wind.put(removeKey, wind.get(removeKey) - 1);
                } else {
                    wind.remove(removeKey);
                }
                left++;
                len--;
            }
        }
        return false;
    }

    public boolean contains(HashMap<Character, Integer> wind, HashMap<Character, Integer> need) {
        Set<Character> keys = need.keySet();
        for (char key : keys) {
            if (wind.getOrDefault(key, 0) < need.get(key)) {
                return false;
            }
        }
        return true;
    }
}

class Test15 {
    public static void main(String[] args) {
        剑指OfferII014字符串中的变位词 test = new 剑指OfferII014字符串中的变位词();
        System.out.println(test.checkInclusion("hello", "ooolleoooleh"));
        System.out.println(test.checkInclusion("ab", "eidbaooo"));
        System.out.println(test.checkInclusion("ab", "eidbaooo"));
    }
}