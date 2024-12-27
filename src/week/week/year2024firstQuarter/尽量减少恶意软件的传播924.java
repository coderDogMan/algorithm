package week.week.year2024firstQuarter;

import java.util.LinkedList;

public class 尽量减少恶意软件的传播924 {
    int n;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        n = graph.length;
        int ans = 0;
        int num = 0;
        for (int i = 0; i < initial.length; i++) {
            int x = bfs(graph, initial[i]);
            if (x > num) {
                num = x;
                ans = i;
            }
        }
        return ans;
    }

    private int bfs(int[][] graph, int i) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(i);
        vis[i] = true;
        int res = 1;
        while (!q.isEmpty()) {
            Integer x = q.poll();
            for (int j = 0; j < n; j++)
                if (graph[x][j] == 1 && x != j && !vis[j]) {
                    res++;
                    q.add(j);
                    vis[j] = true;
                }
        }
        return res;
    }


}
