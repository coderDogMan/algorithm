package week.week339;

import java.util.LinkedList;
import java.util.Scanner;

public class 网格图中鱼的最大数目2658 {
    int n;
    int m;
    int ans;
    int[][] grid;
    int[][] points = new int[][]{{-1, 0}, {1, 0}, {0, -1},{0, 1}};
    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] <= 0) continue;
                bfs(i, j);
            }
        }
        return ans;
    }
    public void bfs(int row, int col) {
        int num = 0;
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{row, col});
        num += grid[row][col];
        grid[row][col] = -1;
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            int x = val[0];
            int y = val[1];
            for (int[] point : points) {
                int nx = x + point[0];
                int ny = y + point[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] > 0) {
                    num += grid[nx][ny];
                    grid[nx][ny] = -1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        ans = Math.max(ans, num);
    }
}

class Test9 {
    public static void main(String[] args) {
        网格图中鱼的最大数目2658 test = new 网格图中鱼的最大数目2658();
        test.findMaxFish(new int[][]{
                {0,4}
        });
//        test.findMaxFish(new int[][]{
//                {0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}
//        });
    }
}