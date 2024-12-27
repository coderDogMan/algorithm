package other.mid;

import java.util.Arrays;
import java.util.LinkedList;

public class 腐烂的橘子994 {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        int bad = 0;
        int sum = 0;
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                } else if (grid[i][j] == 2) {
                    sum++;
                    bad++;
                    queue.addLast(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] val = queue.poll();
                int x = val[0];
                int y = val[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    bad++;
                    queue.addLast(new int[]{x - 1, y});
                }
                if (x + 1 < n && grid[x + 1][y] == 1) {
                    bad++;
                    queue.addLast(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    bad++;
                    queue.addLast(new int[]{x, y - 1});
                }
                if (y + 1 < m && grid[x][y + 1] == 1) {
                    bad++;
                    queue.addLast(new int[]{x, y + 1});
                }
            }
            ans++;
        }
        return bad == sum ? ans : -1;
    }
}

class Test28 {
    public static void main(String[] args) {
        腐烂的橘子994 test = new 腐烂的橘子994();
        test.orangesRotting(new int[][]{
                {2,1,1},{1,1,0},{0,1,1}
        });
    }
}