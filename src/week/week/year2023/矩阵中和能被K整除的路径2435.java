package week.week.year2023;

import java.util.Arrays;

public class 矩阵中和能被K整除的路径2435 {

    private static final int MOD = (int) 1e9 + 7;
    int[][] grid;
    int k;
    int[][][] memo;
    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        int n = grid.length;
        int m = grid[0].length;
        memo = new int[n][m][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(n - 1, m - 1, 0);

    }

    private int dfs(int n, int m, int mod) {
        if (n < 0 || m < 0 ) return 0;
        if (n == 0 && m == 0) return mod == 0 ? 1 : 0;

        long res2 = dfs(n - 1, m, (mod + grid[n][m]) % k);
        res2 += dfs(n, m - 1, (mod + grid[n][m]) % k);

        memo[n][m][mod] = (int) ( res2 % MOD);
        return memo[n][m][mod];
    }
}

class Test55 {
    public static void main(String[] args) {
        矩阵中和能被K整除的路径2435 test = new 矩阵中和能被K整除的路径2435();
        test.numberOfPaths(new int[][]{{5,2,4}, {3,0,5}, {0,7,2}},3);

    }
}
