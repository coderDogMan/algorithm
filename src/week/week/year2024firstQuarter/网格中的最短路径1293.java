package week.week.year2024firstQuarter;

import java.util.LinkedList;

public class 网格中的最短路径1293 {

    int[][] points = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 1 && m == 1) return 0;
        boolean[][][] vis = new boolean[n][m][k];
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, k - grid[0][0]});
        for (int i = 0; i < k; i++) vis[0][0][i] = true;
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] poll = q.poll();
                int x = poll[0], y = poll[1], v = poll[2];
                for (int[] point : points) {
                    int nx = x + point[0], ny = y + point[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        int nv = v - grid[nx][ny];
                        if (nv < 0) continue;
                        if (nx == n - 1 && ny == m - 1) return ans;
                        if (!vis[nx][ny][nv]) {
                            q.add(new int[]{nx, ny, nv});
                            vis[nx][ny][nv] = true;
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}

class Test25 {
    public static void main(String[] args) {
        网格中的最短路径1293 test = new 网格中的最短路径1293();
        test.shortestPath(new int[][]{{0, 1}, {1,1},{0,0}}, 2);
    }
}
