package week.week387;

public class T3 {

    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] cntY = new int[3];
        int[] cntX = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cntX[grid[i][j]]++;
            }
        }
        for (int i = 0; i < n / 2; i++) cntY[grid[i][i]]++;
        for (int i = 0, j = n - 1; i < n / 2; i++, j--) cntY[grid[i][j]]++;
        for (int i = n / 2; i < n; i++) cntY[grid[i][n / 2]]++;

        cntX[0] -= cntY[0];
        cntX[1] -= cntY[1];
        cntX[2] -= cntY[2];
        int sumX = cntX[0] + cntX[1] + cntX[2];
        int sumY = cntY[0] + cntY[1] + cntY[2];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                ans = Math.min(ans, sumX - cntX[i] + sumY - cntY[j]);
            }
        }
        return ans;
    }

}
