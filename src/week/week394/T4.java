package week.week394;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class T4 {

    long[] dis;
    Long INF = Long.MAX_VALUE / 3;
    LinkedList<int[]>[] g;
    boolean[] ans;
    public boolean[] findAnswer(int n, int[][] edges) {
        int m = edges.length;
        ans = new boolean[m];
        g = new LinkedList[n];
        Arrays.setAll(g, e -> new LinkedList());
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            g[e[0]].add(new int[]{e[1], e[2], i});
            g[e[1]].add(new int[]{e[0], e[2], i});
        }

        dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] dxPair = pq.poll();
            long dx = dxPair[0];
            int x = (int) dxPair[1];
            if (dx > dis[x]) {
                continue;
            }
            for (int[] t : g[x]) {
                int y = t[0];
                int w = t[1];
                long newDis = dx + w;
                if (newDis < dis[y]) {
                    dis[y] = newDis;
                    pq.offer(new long[]{newDis, y});
                }
            }
        }

        boolean[] vis = new boolean[n];
        dfs(n - 1, vis);
        return ans;
    }

    private void dfs(int y, boolean[] vis) {
        vis[y] = true;
        for (int[] son : g[y]) {
            int x = son[0];
            int w = son[1];
            int i = son[2];
            if (dis[x] + w == dis[y]) continue;
                ans[i] = true;
            if (!vis[x]) dfs(x, vis);
        }
    }


}
