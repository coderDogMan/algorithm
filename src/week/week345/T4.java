package week.week345;

import java.util.Arrays;
import java.util.LinkedList;

class T4 {
    LinkedList<Integer>[] edge;
    int[] vis;
    public int countCompleteComponents(int n, int[][] edges) {
        edge = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new LinkedList<Integer>();
        }
        vis = new int[n];
        for (int[] val : edges) {
            int u = val[0];
            int v = val[1];
            edge[u].add(v);
            edge[v].add(u);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] != 0) continue;
            int nodeNum = dfs1(-1, i);
            if (dfs2(-1, i, nodeNum - 1)) {
                ans++;
            };
        }
        return ans;

    }

    private boolean dfs2(int fa, int cur, int val) {
        vis[cur] = 2;
        if (edge[cur].size() != val) return false;
        for (Integer son : edge[cur]) {
            if (son == fa) continue;
            if (vis[son] == 2) continue;
            if (!dfs2(cur, son, val)) return false;
        }
        return true;
    }

    private int dfs1(int fa, int cur) {
        vis[cur] = 1;
        int ans = 0;
        for (int son : edge[cur]) {
            if (son == fa) continue;
            if (vis[son] == 1) continue;
            ans = Math.max(ans, dfs1(cur, son));
        }
        return ans + 1;
    }
}
class T42 {
    int e,v;
    boolean[] vis;
    LinkedList<Integer>[] edge;
    public int countCompleteComponents(int n, int[][] edges) {
        edge = new LinkedList[n];
        Arrays.setAll(edge, e -> new LinkedList<>());
        for (int[] e : edges) {
            edge[e[0]].add(e[1]);
            edge[e[1]].add(e[0]);

        }
        vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            e = 0;
            v = 0;
            dfs(i);
            if (e == v * (v - 1)) ans++;
        }
        return ans;
    }

    private void dfs(int cur) {
        vis[cur] = true;
        e += edge[cur].size();
        v++;
        for (Integer son : edge[cur]) {
            if (vis[son]) continue;
            dfs(son);
        }
    }
}
class Test4 {
    public static void main(String[] args) {
        T42 test = new T42();
        test.countCompleteComponents(6, new int[][]{
                {0,1},{0,2},{1,2},{3,4}
        });
    }
}
