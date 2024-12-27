package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 最短公共超序列1092 {

    String s;
    String t;
    int[][] memo;
    public String shortestCommonSupersequence(String s1, String s2) {
        s = s1;
        t = s2;
        memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) Arrays.fill(memo, -1);
        return makeAns(s1.length() - 1, s2.length() - 1);
    }

    private String makeAns(int i, int j) {
        if (i < 0) return t.substring(j + 1);
        if (j < 0) return s.substring(i + 1);
        String ans = "";
        if (s.charAt(i) == t.charAt(j)) return ans = makeAns(i - 1, j - 1) + s.charAt(i);
        if (dfs(i, j) == dfs(i - 1, j) + 1) {
            return makeAns(i - 1, j) + s.charAt(i);
        } else {
            return makeAns(i, j - 1) + t.charAt(j);
        }
    }

    private int dfs(int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (memo[i][j] != -1) return memo[i][j];
        int res = Integer.MAX_VALUE;
        if (s.charAt(i) == t.charAt(j)) {
            res = dfs(i - 1, j - 1) + 1;
        } else {
            res = Math.min(dfs(i - 1, j), dfs(i, j - 1)) + 1;
        }
        return memo[i][j] = res;
    }
}
