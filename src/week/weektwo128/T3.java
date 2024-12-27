package week.weektwo128;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class T3 {
    LinkedList<int[]>[] g;
    int[] dist;
    int INF = Integer.MAX_VALUE / 3;
    int[] disappear;
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        this.disappear = disappear;
        g = new LinkedList[n];
        Arrays.setAll(g, e -> new LinkedList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[] {e[1], e[2]});
            g[e[1]].add(new int[] {e[0], e[2]});
        }
        dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        dijkstra(n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i] >= INF || dist[i] >= disappear[i]) ans[i] = -1;
            else ans[i] = dist[i];
        }
        return ans;
    }

    private void dijkstra(int n) {

        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int id = poll[0], step = poll[1];
            if (vis[id]) continue;
            vis[id] = true;
            for (int[] son : g[id]) {
                int v = son[0];
                int w = son[1];
                if (!vis[v] && step + w < dist[v] && step + w < disappear[v]) {
                    dist[v] = step + w;
                    queue.add(new int[]{v, dist[v]});
                }
            }
        }
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.minimumTime(3, new int[][]{{0,1,2},{1,2,1},{0,2,4}}, new int[]{1,1,5});
    }
}
