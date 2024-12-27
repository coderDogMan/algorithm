package other.mid;

import java.util.HashSet;

public class 剑指OfferII016不含重复字符的最长子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            char key = s.charAt(i);
            if (!set.contains(key)) {
                set.add(key);
                len++;
            } else {
                while (set.contains(key)) {
                    set.remove(s.charAt(left++));
                    len--;
                }
                set.add(key);
                len++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}

class Test13 {
    public static void main(String[] args) {
        剑指OfferII016不含重复字符的最长子字符串 test = new 剑指OfferII016不含重复字符的最长子字符串();
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
    }
}