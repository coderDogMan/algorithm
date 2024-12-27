package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 字符串中的额外字符2707 {
    String s;
    HashSet<String> set;
    int[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        this.s = s;
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        this.set = new HashSet<>();
        for (String s1 : dictionary) {
            set.add(s1);
        }
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == s.length());
        if (memo[i] != -1) return memo[i];
        int res = dfs(i + 1) + 1;
        for (int j = i + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(i, j))) {
                res = Math.min(res, dfs(j));
            }
        }
        memo[i] = res;
        return res;

    }
}
