package writtentest.elm2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 闯关 {
    static int INF = Integer.MAX_VALUE / 2;
    static int n;
    static LinkedList<int[]>[] g;
    static int[] dist;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        g = new LinkedList[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new LinkedList();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }
        long ans = 0;
        dijkstra();
        for (int i = 0; i < q; i++) {
            int idx = in.nextInt();
            ans += (dist[idx] >= INF ? 0 : dist[idx]);
        }
        System.out.println(ans * 2);
    }

    private static void dijkstra() {
        Arrays.fill(dist, INF);
        boolean[] vis = new boolean[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int id = poll[0], step = poll[1];
            if (vis[id]) continue;
            vis[id] = true;
            for (int[] son : g[id]) {
                int v = son[0];
                int w = son[1];
                if (!vis[v] && step + w < dist[v]) {
                    dist[v] = step + w;
                    queue.add(new int[]{v, dist[v]});
                }
            }
        }
    }
}
