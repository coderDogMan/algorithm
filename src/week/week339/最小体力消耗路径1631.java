package week.week339;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 最小体力消耗路径1631 {
    int n, m;
    int[][] dirs = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
    boolean[][] vis;
    public int minimumEffortPath(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        int l = 0, r = (int)1e6;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(heights, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[][] heights, int mid) {
        vis = new boolean[n][m];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            int x = val[0], y = val[1];
            if (x == n - 1 && y == m - 1) return true;
            int num = heights[x][y];
            for (int[] point : dirs) {
                int nx = x + point[0];
                int ny = y + point[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && Math.abs(heights[nx][ny] - num) <= mid && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
class Test8 {
    public static void main(String[] args) {
        最小体力消耗路径1631 test = new 最小体力消耗路径1631();
        test.minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}});
    }
}
