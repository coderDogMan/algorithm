package week.week.year2023;

public class 不同路径III980 {
    int n;
    int m;
    boolean[][] vis;
    int[][] grid;
    int sx;
    int sy;
    int ans = 0;
    int cnt = 0;
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        this.grid = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 0) {
                    cnt++;
                }
            }
        }
        dfs(sx, sy, 0);
        return ans;
    }

    public void dfs(int i, int j, int num) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == -1 || vis[i][j]) {
            return;
        }
        if (grid[i][j] == 2) {
            if (num == cnt + 1) ans++;
            return;
        }
        vis[i][j] = true;
        dfs(i + 1, j, num + 1);
        dfs(i - 1, j, num + 1);
        dfs(i, j + 1, num + 1);
        dfs(i, j - 1, num + 1);
        vis[i][j] = false;
    }
}

class Test82 {
    public static void main(String[] args) {
        不同路径III980 test = new 不同路径III980();
        System.out.println(test.uniquePathsIII(new int[][]{{0, 1},
                                                            {2, 0}}));
    }
}