package writtentest.huawei2023;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 光芒散射 {
    static int m;
    static int n;
    static int ans;
    static boolean[][] vis;
    static int[][] map;
    static int[][] dist;
    static int[][] points = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int startI;
    static int startJ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        startI = in.nextInt();
        startJ = in.nextInt();
        vis = new boolean[n][m];
        map = new int[n][m];
        dist = new int[n][m];
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] != 0) num++;
            }
        }
        dijkstra();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] < Integer.MAX_VALUE / 2) {
                    num--;
                    ans = Math.max(ans, dist[i][j]);
                }
            }
        }
        if (num != 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    private static void dijkstra() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        dist[startI][startJ] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (dist[a[0]][a[1]] - dist[b[0]][b[1]]));
        queue.add(new int[]{startI, startJ});
        vis[startJ][startJ] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int[] point : points) {
                int nx = x + point[0];
                int ny = y + point[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 0 && dist[nx][ny] > dist[x][y] + map[x][y]) {
                    dist[nx][ny] = dist[x][y] + map[x][y];
                    vis[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }


    }

}