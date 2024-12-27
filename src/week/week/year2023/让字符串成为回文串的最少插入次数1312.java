package week.week.year2023;

public class 让字符串成为回文串的最少插入次数1312 {

    String s;
    int ans = 0;
    int[][] memo;
    public int minInsertions(String s) {
        this.s = s;
        int n = s.length();
        memo = new int[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int j, int i) {
        if (j > i) return 0;
        if (j == i) {
            memo[i][j] = 1;
            return 1;
        }
        if (memo[i][j] != 0) return memo[i][j];
        if (s.charAt(j) == s.charAt(i)) {
            memo[i][j] = memo[i + 1][j - 1] + 2;
        } else {
            memo[i][j] = Math.max(dfs(j - 1, i), Math.max(dfs(j, i + 1), dfs(j - 1, i+ 1)));
        }

        return memo[i][j];


    }

    private boolean check(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }


}
