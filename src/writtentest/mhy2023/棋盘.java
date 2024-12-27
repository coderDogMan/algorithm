package writtentest.mhy2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 棋盘 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n][m];
        int xa = in.nextInt() - 1;
        int ya = in.nextInt() - 1;
        int xb = in.nextInt() - 1;
        int yb = in.nextInt() - 1;
        int xc = in.nextInt() - 1;
        int yc = in.nextInt() - 1;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{xa, ya});
        int[][] points = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        boolean find = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x == xb && y == yb) {
                    find = true;
                    break;
                }
                for (int[] point : points) {
                    int newX = (x + n + point[0]) % n;
                    int newY = (y + m + point[1]) % m;
                    if (map[newX][newY] == 0) {
                        queue.add(new int[]{newX, newY});
                        map[newX][newY] = 1;
                    }
                }

            }
            if (find) break;
            ans++;
        }
        queue.clear();
        queue.add(new int[]{xb, yb});
        find = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x == xc && y == yc) {
                    find = true;
                    break;
                }
                for (int[] point : points) {
                    int newX = (x + n + point[0]) % n;
                    int newY = (y + m + point[1]) % m;
                    if (map[newX][newY] == 0 || map[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY});
                        map[newX][newY] = 2;
                    }
                }

            }
            if (find) break;
            ans++;
        }
        System.out.println(ans);
    }
}
