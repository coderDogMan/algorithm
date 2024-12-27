package week.week.year2023;

import java.util.*;

public class 价格范围内最高排名的K样物品2146 {

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] points = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(start);
        vis[start[0]][start[1]] = true;
        List<List<Integer>> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            queue.sort((a, b) -> {
                int aVal = grid[a[0]][a[1]];
                int bVal = grid[b[0]][b[1]];
                return aVal != bVal ? aVal - bVal : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            });
            for (int[] q : queue) {
                if (grid[q[0]][q[1]] >= pricing[0] && grid[q[0]][q[1]] <= pricing[1]) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(q[0]);
                    list.add(q[1]);
                    ans.add(list);
                    if (ans.size() == k) return ans;
                }
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int[] point : points) {
                    int nx = x + point[0];
                    int ny = y + point[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != 0 && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return ans;
    }
}
class Test84 {
    public static void main(String[] args) {
        价格范围内最高排名的K样物品2146 test = new 价格范围内最高排名的K样物品2146();
        test.highestRankedKItems(new int[][]{{1,0,1},
                                             {3,5,2},
                                             {1,0,1}},
                new int[]{2, 5}, new int[]{1, 1}, 9);
    }
}
