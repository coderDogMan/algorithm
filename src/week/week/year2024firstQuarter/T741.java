package week.week.year2024firstQuarter;

import java.util.Arrays;

public class T741 {

    int n;
    int[][] grid;
    int[][][][] memo;
    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        memo = new int[n][n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) Arrays.fill(memo[i][j][k], -1);
            }
        }
        int ans = dfs(0, 0, 0, 0);
        return ans < 0 ? 0 : ans;
    }

    private int dfs(int x1, int y1, int x2, int y2) {
        if (x1 == n - 1 && y1 == n - 1) {
            return grid[n - 1][n - 1];
        }
        if (x1 >= n || y1 >= n || x2 >= n || y2 >= n) return Integer.MIN_VALUE / 2;
        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) return Integer.MIN_VALUE / 2;
        if (memo[x1][y1][x2][y2] != -1) return memo[x1][y1][x2][y2];
        int res = Integer.MIN_VALUE / 2;
        res = Math.max(res, dfs(x1 + 1, y1, x2 + 1, y2));
        res = Math.max(res, dfs(x1, y1 + 1, x2, y2 + 1));
        res = Math.max(res, dfs(x1 + 1, y1, x2, y2 + 1));
        res = Math.max(res, dfs(x1, y1 + 1, x2 + 1, y2));
        if (x1 == x2) res += grid[x1][y1];
        else res += grid[x1][y1] + grid[x2][y2];

        return memo[x1][y1][x2][y2] = res;
    }
}
