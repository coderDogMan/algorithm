package week.week.year2024firstQuarter;

import java.util.Arrays;

public class T1463 {
    int n, m;
    int[][] grid;
    int[] points;
    int[][][] memo;
    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        points = new int[]{-1, 0, 1};
        memo = new int[n][m][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) Arrays.fill(memo[i][j], -1);
        return dfs(0, 0, m - 1);

    }

    private int dfs(int x, int y1, int y2) {
        if (x == n - 1) {
            if (y1 == y2) return grid[x][y1];
            else return grid[x][y1] + grid[x][y2];
        }
        if (memo[x][y1][y2] != -1) return memo[x][y1][y2];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int ny1 = y1 + points[i];
                int ny2 = y2 + points[j];
                if (ny1 >= 0 && ny1 < m && ny2 >= 0 && ny2 < m)
                    res = Math.max(res, dfs(x + 1, ny1, ny2) + (y1 == y2 ? grid[x][y1] : grid[x][y1] + grid[x][y2]));
            }
        }
        return memo[x][y1][y2] = res;
    }
}
