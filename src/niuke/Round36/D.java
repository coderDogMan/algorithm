package niuke.Round36;

import java.util.LinkedList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[][] vis = new boolean[n][m];
        if (n == 1 && m == 1) {
            System.out.println(0);
            return;
        }
        String[] map = new String[n];
        for (int i = 0; i < n; i++) map[i] = in.next();
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, map[0].charAt(0)});
        vis[0][0] = true;
        int[][] points = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int x = node[0], y = node[1], v = node[2];
                for (int[] point : points) {
                    int nx = x + point[0];
                    int ny = y + point[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny] && map[nx].charAt(ny) != v) {
                        if (nx == n - 1 && ny == m - 1) {
                            System.out.println(ans);
                            return;
                        }
                        q.add(new int[] {nx, ny, map[nx].charAt(ny)});
                        vis[nx][ny] = true;
                    }
                }
            }
            ans++;
        }

        System.out.println(-1);


    }
}
