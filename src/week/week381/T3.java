package week.week381;

import java.util.Arrays;
import java.util.LinkedList;

public class T3 {

    public long[] countOfPairs(int n, int x, int y) {
        long[] ans = new long[n];
        boolean[] glob = new boolean[n + 1];
        LinkedList<Integer>[] g = new LinkedList[n + 1];
        Arrays.setAll(g, e -> new LinkedList());
        for (int i = 1; i < n; i++) {
            g[i].add(i + 1);
            g[i + 1].add(i);
        }
        g[x].add(y);
        g[y].add(x);
        for (int node = 1; node <= n; node++) {
            glob[node] = true;
            boolean[] vis = glob.clone();
            LinkedList<Integer> q = new LinkedList<>();
            q.add(node);
            vis[node] = true;
            int k = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = q.poll();
                    for (Integer son : g[poll]) {
                        if (!vis[son]) {
                            q.add(son);
                            vis[son] = true;
                        }
                    }
                }
                ans[k++] += q.size() * 2;
            }
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.countOfPairs(3, 1, 2);
    }
}