package week.week.year2023;

import java.util.LinkedList;

public class 地图中的最高点1765 {
    public int[][] highestPeak(int[][] isWater) {
        LinkedList<int[]> queue = new LinkedList<>();
        int n = isWater.length;
        int m = isWater[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    vis[i][j] = true;
                    isWater[i][j] = 0;
                }
            }
        }
        int ans = 1;
        int[][] points = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int X = poll[0];
                int Y = poll[1];
                for (int[] point : points) {
                    int x = X + point[0];
                    int y = Y + point[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
                        vis[x][y] = true;
                        isWater[x][y] = ans;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            ans++;
        }
        return isWater;
    }
}
