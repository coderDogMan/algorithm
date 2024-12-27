package week.weektwo130;

/**
 * @Author: min
 * @Date:
 */
public class T1 {

    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (grid[i][j] != grid[i - 1][j]) return false;
            }
        }
        for (int j = 1; j < m; j++) if (grid[0][j - 1] == grid[0][j]) return false;
        return true;
    }

}
