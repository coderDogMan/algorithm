package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 石子游戏VII1690 {
    int[] sum;
    int[][] memo;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + stones[i - 1];
        memo = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res1 = sum[j + 1] - sum[i + 1] - dfs(i + 1, j);
        int res2 = sum[j] - sum[i] - dfs(i, j - 1);
        return memo[i][j] = Math.max(res1, res2);
    }
}
