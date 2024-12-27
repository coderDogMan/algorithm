package week.week.year2023;

import java.util.Arrays;

public class 最长理想子序列2370 {

    String s;
    int k;
    int[][] memo;
    public int longestIdealString(String s, int k) {
        this.s = s;
        this.k = k;
        int n = s.length();
        int ans = 0;
        memo = new int[n][26];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            // 选当前的， 看下一个
            ans = Math.max(ans, dfs(i + 1, cur) + 1);
        }
        return ans;
    }

    private int dfs(int i, int cur) {
        if (i == s.length()) return 0;
        if (memo[i][cur] != -1) return memo[i][cur];
        int res = 0;
        int num = s.charAt(i) - 'a';
        if (Math.abs(cur - num) <= k) {
            res = Math.max(dfs(i + 1, num) + 1, dfs(i + 1, cur));
        } else {
            res = dfs(i + 1, cur);
        }

        memo[i][cur] = res;
        return res;
    }
}
