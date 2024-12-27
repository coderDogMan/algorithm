package week.week.year2024firstQuarter;

import java.util.HashSet;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(i));
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
