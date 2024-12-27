package week.week.year2023;

import java.util.Arrays;

public class 矩阵的最大非负积1594 {

    public static final int MOD = (int) 1e9 + 7;
    int n;
    int m;
    int[][] grid;
    long[][][] memo;
    public int maxProductPath(int[][] grid) {
        n = grid.length;;
        m = grid[0].length;;
        this.grid = grid;
        memo = new long[n][m][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(memo[i][j], Long.MIN_VALUE);
        long ans = dfs(n - 1, m - 1, 0);
        return ans >= 0 ? (int) (ans % MOD) : -1;
    }

    private long dfs(int i, int j, int op) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (memo[i][j][op] != Long.MIN_VALUE) return memo[i][j][op];
        long res1 = Long.MIN_VALUE;
        long res2 = Long.MIN_VALUE;
        long res3 = Long.MIN_VALUE;
        long res4 = Long.MIN_VALUE;

        if (i - 1 >= 0) {
            res1 = dfs(i - 1, j, 0) * grid[i][j];
            res2 = dfs(i - 1, j, 1) * grid[i][j];
        }

        if (j - 1 >= 0) {
            res3 = dfs(i, j - 1, 0) * grid[i][j];
            res4 = dfs(i, j - 1, 1) * grid[i][j];
        }
        if (op == 0) {
            long res = max(new long[]{res1, res2, res3, res4});
            memo[i][j][op] = res;
        } else {
            long res = min(new long[]{res1, res2, res3, res4});
            memo[i][j][op] = res;
        }

        return memo[i][j][op];
    }

    private long min(long[] nums) {
        long min = Integer.MAX_VALUE;
        for (long num : nums) {
            if (num == Long.MIN_VALUE) continue;
            min = Math.min(min, num);
        }
        return min;
    }

    private long max(long[] nums) {
        long max = Integer.MIN_VALUE;
        for (long num : nums) {
            if (num == Long.MIN_VALUE) continue;
            max = Math.max(max, num);
        }
        return max;
    }
}

class Test65 {
    public static void main(String[] args) {
        矩阵的最大非负积1594 test = new 矩阵的最大非负积1594();
        test.maxProductPath(new int[][]{{1,-2,1},{1,-2,1},{3,-4,1}});
    }

}