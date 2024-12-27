package week.week387;

public class T2 {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1;  j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1;  j <= m; j++) {
                if (sum[i][j] <= k) ans++;
            }
        }
        return ans;
    }
}
