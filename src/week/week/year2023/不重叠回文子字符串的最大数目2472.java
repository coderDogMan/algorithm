package week.week.year2023;

import java.util.Arrays;

public class 不重叠回文子字符串的最大数目2472 {

    String s;
    int k;
    int[] memo;
    boolean[][] dp;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        this.s = s;
        this.k = k;
        int ans = 0;
        dp = new boolean[n][n];
        // dp[i][j] = dp[i + 1][j - 1]
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == s.length()) return 0;
        if (memo[i] != -1) return memo[i];

        int res = dfs(i + 1) + (k == 1 ? 1 : 0);
        for (int j = i + k; j <= s.length(); j++) {
//            if (j - i < k) continue;
            if (dp[i][j - 1]) {
                res = Math.max(res, dfs(j) + 1);
            }
        }
        memo[i] = res;
        return res;
    }

//    private boolean check(String s) {
//        int l = 0;
//        int r = s.length() - 1;
//        while (l < r) {
//            if (s.charAt(l) != s.charAt(r)) return false;
//            l++;
//            r--;
//        }
//        return true;
//    }
}

class Test56 {
    public static void main(String[] args) {
        不重叠回文子字符串的最大数目2472 test = new 不重叠回文子字符串的最大数目2472();
        test.maxPalindromes("aaa", 1);
//        test.maxPalindromes("abaccdbbd", 3);
    }
}
