package graph.mid;

import java.util.LinkedList;
import java.util.Queue;

public class 统计封闭岛屿的数目1254 {
    public static void main(String[] args) {
        int i = closedIsland(new int[][]{{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}});
        System.out.println(i);
    }

    public static int closedIsland(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        if (grid[x][y] == 0 && (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1))
                            flag = false;
                        grid[x][y] = 2;
                        //上
                        if (x > 0 && grid[x - 1][y] == 0) {
                            queue.offer(new int[]{x - 1, y});
                        }
                        //下
                        if (x < grid.length - 1 && grid[x + 1][y] == 0) {
                            queue.offer(new int[]{x + 1, y});
                        }
                        //左
                        if (y > 0 && grid[x][y - 1] == 0) {
                            queue.offer(new int[]{x, y - 1});
                        }
                        //右
                        if (y < grid[0].length - 1 && grid[x][y + 1] == 0) {
                            queue.offer(new int[]{x, y + 1});
                        }
                    }
                    if (flag) sum++;
                    flag = true;
                }
            }
        }
        return sum;
    }

}
