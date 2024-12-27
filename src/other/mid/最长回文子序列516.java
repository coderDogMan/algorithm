package other.mid;

public class 最长回文子序列516 {
    String s;
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        this.s = s;
        return dfs(0, n - 1);
    }

    private int dfs(int j, int i) {
        if (j > i) return 0;
        if (i == j) {
            dp[i][j] = 1;
            return 1;
        }
        if (dp[i][j] != 0) return dp[i][j];
        if (s.charAt(j) == s.charAt(i)) {
            dp[i][j] = dfs(j + 1, i - 1) + 2;
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(dfs(j + 1, i), Math.max(dfs(j, i - 1), dfs(j + 1, i - 1)));
            return dp[i][j];
        }
    }
}

class Test39 {
    public static void main(String[] args) {
        最长回文子序列516 test = new 最长回文子序列516();
        test.longestPalindromeSubseq("cbbd");
    }
}
