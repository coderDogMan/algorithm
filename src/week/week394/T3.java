package week.week394;

import java.util.Arrays;

public class T3 {

    int[][] grid;
    int[][] sum;
    int n, m;
    int[][] memo;
    public int minimumOperations(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        sum = new int[m][10];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int x = grid[i][j];
                sum[j][x]++;
            }
        }
        memo = new int[m][11];
        for (int i = 0; i < m; i++) Arrays.fill(memo[i], -1);
        return dfs(0, 10);

    }

    private int dfs(int j, int last) {
        if (j == m) return 0;
        if (memo[j][last] != -1) return memo[j][last];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 9; i++) {
            if (i == last) continue;
            res = Math.min(res, dfs(j + 1, i) + (n - sum[j][i]));
        }
        return memo[j][last] = res;
    }

}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.minimumOperations(new int[][]{   {4,2,2},
                                            {8,2,5},
                                            {1,5,2}});
        System.out.println(t3.minimumOperations(new int[][]{{1, 0, 2}, {1, 0, 2}}));
    }
}