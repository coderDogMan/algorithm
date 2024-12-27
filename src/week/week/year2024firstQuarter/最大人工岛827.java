package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.HashSet;

public class 最大人工岛827 {

    int[] fa;
    int[] sum;
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        fa = new int[n * n + 2];
        sum = new int[n * n + 2];
        Arrays.fill(sum, 1);
        int[][] points = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i <= n * n + 1; i++) fa[i] = i;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int x = i * n + j;
                    for (int[] point : points) {
                        int nx = i + point[0];
                        int ny = j + point[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            int pa = find(nx * n + ny), pb = find(x);
                            if (pa == pb) continue;
                            fa[pa] = pb;
                            sum[pb] += sum[pa];
                            ans = Math.max(ans, sum[pb]);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    HashSet<Integer> vis = new HashSet<>();
                    for (int[] point : points) {
                        int nx = i + point[0];
                        int ny = j + point[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            int son = find(nx * n + ny);
                            if (vis.contains(son)) continue;
                            cur += sum[son];
                            vis.add(son);
                        }
                    }
                    ans = Math.max(ans, cur);
                }
            }
        }
        return ans;
    }

    private int find(int a) {
        if (a != fa[a]) fa[a] = find(fa[a]);
        return fa[a];
    }
}

class Test15 {
    public static void main(String[] args) {
        最大人工岛827 test = new 最大人工岛827();
        test.largestIsland(new int[][]{{1,1,1},{1,1,1},{1,1,1}});
    }
}