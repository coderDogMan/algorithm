package writtentest.shuzimali;

import java.util.LinkedList;
import java.util.Scanner;

public class C {
    static int[][] points = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public  static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int startX = in.nextInt() - 1;
        int startY = in.nextInt() - 1;
        int endX = in.nextInt() - 1;
        int endY = in.nextInt() - 1;
        if (startX == endX && startY == endY) {
            System.out.println(0);
            return;
        }
        String[] map = new String[n];
        for (int i = 0; i < n; i++)
            map[i] = in.next();
        boolean[][] vis = new boolean[n][m];
        LinkedList<int[]> queue = new LinkedList<>();
        vis[startX][startY] = true;
        queue.add(new int[]{startX, startY});
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int[] point : points) {
                    int nx = x + point[0];
                    int ny = y + point[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx].charAt(ny) != '*' && !vis[nx][ny]) {
                        if (nx == endX && ny == endY) {
                            System.out.println(ans);
                            return;
                        }
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        System.out.println(-1);
    }

}
