package week.week.year2023;

import java.util.Arrays;

public class 所有子字符串美丽值之和1781 {
    public int beautySum(String s) {
        if (s.length() < 3) return 0;
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int n = chars.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(map, 0);
            for (int j = i; j < n; j++) {
                map[chars[j] - 'a']++;
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    max = Math.max(max, map[k]);
                    if (map[k] != 0) {
                        min = Math.min(min, map[k]);
                    }
                }
                ans += (max - min);
            }

        }
        return ans;
    }
}
