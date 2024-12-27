package week.week397;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: min
 * @Date:
 */
public class T3 {

    int n, m;
    List<List<Integer>> grid;
    // dp[i][j] = maxRow - grid[i][j], maxCol - grid[i][j], dp[i + 1][j] + grid[i][j] - grid[i + 1][j], dp[i][j + 1] + grid[i][j] - grid[i + 1][j];
    public int maxScore(List<List<Integer>> grid) {
        n = grid.size();
        m = grid.get(0).size();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        int[] colMax = new int[m];
        for (int j = 0; j < m; j++)
            colMax[j] = grid.get(n - 1).get(j);
        int curMax = grid.get(n - 1).get(m - 1);

        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j] = Math.max(curMax - grid.get(n - 1).get(j), dp[n - 1][j + 1] + grid.get(n - 1).get(j + 1) - grid.get(n - 1).get(j));
            curMax = Math.max(curMax, grid.get(n - 1).get(j));
        }

        curMax = grid.get(n - 1).get(m - 1);
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = Math.max(curMax - grid.get(i).get(m - 1), dp[i + 1][m - 1] + grid.get(i + 1).get(m - 1) - grid.get(i).get(m - 1));
            curMax = Math.max(curMax, grid.get(i).get(m - 1));
        }

        for (int i = n - 2; i >= 0; i--) {
            int maxRow = grid.get(i).get(m - 1);
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.max(maxRow - grid.get(i).get(j), colMax[j] - grid.get(i).get(j)),
                        Math.max(dp[i + 1][j] + grid.get(i + 1).get(j) - grid.get(i).get(j), dp[i][j + 1] + grid.get(i).get(j + 1)) - grid.get(i).get(j));
                maxRow = Math.max(maxRow, grid.get(i).get(j));
                colMax[j] = Math.max(colMax[j], grid.get(i).get(j));
            }
        }

        return dp[0][0];
    }


}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(4);
        l1.add(3);
        l1.add(2);
        l2.add(3);
        l2.add(2);
        l2.add(1);
        List<List<Integer>> grid = new LinkedList<>();
        grid.add(l1);
        grid.add(l2);
        t3.maxScore(grid);
    }
}