package week.week339;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    int[][] g;
    int[] dit;
    boolean[] vis;
    int INF = Integer.MAX_VALUE / 2;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        g = new int[n][n];
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[3];
        }
    }

    public void addEdge(int[] edge) {
        g[edge[0]][edge[1]] = edge[3];
    }

    public int shortestPath(int start, int end) {
        dit = new int[n];
        vis = new boolean[n];
        Arrays.fill(dit, INF);
        dit[start] = 0;
        int x = -1;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (!vis[i] && (x < 0 || dit[i] < dit[x]))
                    x = i;
            }
            if (x == -1 || dit[x] == INF) return -1;
            if (x == end) return dit[x];
            for (int y = 0; y < n; y++) {
                dit[y] = Math.min(dit[y], dit[x] + g[x][y]);
            }
        }
    }
}
