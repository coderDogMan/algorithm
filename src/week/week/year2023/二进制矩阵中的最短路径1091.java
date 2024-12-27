package week.week.year2023;

import java.util.LinkedList;

public class 二进制矩阵中的最短路径1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1 && grid[0][0] == 0) return 1;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] points = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1},{1, 1}};
        queue.add(new int[]{0, 0});
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                for (int[] point : points) {
                    int nx = x + point[0];
                    int ny = y + point[1];
                    if (nx == n - 1 && ny == n - 1) {
                        return ans + 1;
                    }
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}

class Test4 {
    public static void main(String[] args) {
        二进制矩阵中的最短路径1091 test = new 二进制矩阵中的最短路径1091();
        test.shortestPathBinaryMatrix(new int[][]{{0}});
//        test.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}});
    }
}