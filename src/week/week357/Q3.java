package week.week357;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q3 {
    int[][] map;
    int[][] points = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        LinkedList<int[]> queue = new LinkedList<>();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j});
                    map[i][j] = -1;
                }
            }
        }
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int X = poll[0];
                int Y = poll[1];
                for (int[] point : points) {
                    int x = X + point[0];
                    int y = Y + point[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && map[x][y] == 0) {
                        map[x][y] = res;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            res++;
        }
        int l = 0;
        int r = 2 * n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r > 0 ? r : 0;
    }

    private boolean check(int mid) {
        if (map[0][0] < mid) return false;
        boolean[][] vis = new boolean[n][n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int X = poll[0];
                int Y = poll[1];
                for (int[] point : points) {
                    int x = X + point[0];
                    int y = Y + point[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && map[x][y] >= mid && vis[x][y] != true) {
                        if (x == n - 1 && y == n - 1) return true;
                        queue.add(new int[]{x, y});
                        vis[x][y] = true;
                    }

                }
            }
        }
        return false;
    }
}

class Test3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> e1    = new ArrayList<Integer>();
        e1.add(0);
        e1.add(1);
        e1.add(1);
        ArrayList<Integer> e2    = new ArrayList<Integer>();
//        e2.add(0);
        e2.add(1);
        e2.add(1);
        e2.add(1);
        ArrayList<Integer> e3    = new ArrayList<Integer>();
        e3.add(1);
        e3.add(1);
        e3.add(0);
//        e3.add(0);
        ArrayList<Integer> e4    = new ArrayList<Integer>();
        e4.add(1);
        e4.add(0);
        e4.add(0);
        e4.add(0);
        list.add(e1);
        list.add(e2);
        list.add(e3);
//        list.add(e4);
        q3.maximumSafenessFactor(list);
    }
}

//        [0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0],
//        [0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0],
//        [0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0],
//        [0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,1],
//        [0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0],
//        [0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0],
//        [0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1],
//        [1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0],
//        [0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,1],
//        [0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0],
//        [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1,1,0,0,0],
//        [0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0],
//        [0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0],
//        [0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0],
//        [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
//        [0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0],
//        [0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0],
//        [0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0]]