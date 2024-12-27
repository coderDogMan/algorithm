package week.week.year2023;

import java.util.Arrays;

public class 设计可以求最短路径的图类2642 {

    int[][] g;
    Integer INF = Integer.MAX_VALUE >> 1;
    int n = 0;
    public 设计可以求最短路径的图类2642(int n, int[][] edges) {
        this.n = n;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(g[i], INF);
        for (int[] edge : edges) {
            g[edge[0]][edge[1]] = edge[2];
        }
    }

    public void addEdge(int[] edge) {
        g[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int start, int end) {
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && (x < 0 || dist[i] < dist[x]))
                    x = i;
            }
            if (x < 0 || dist[x] == INF)
                return -1;
            if (x == end)
                return dist[x];
            vis[x] = true;
            for (int y = 0; y < n; y++)
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
        }
    }

}
