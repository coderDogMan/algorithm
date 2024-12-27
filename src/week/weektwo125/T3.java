package week.weektwo125;

import writtentest.huawei2023.分配资源ID;

import java.util.Arrays;
import java.util.LinkedList;

public class T3 {

    int signalSpeed;
    LinkedList<int[]>[] g;
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        int[] ans = new int[n];
        this.signalSpeed = signalSpeed;
        g = new LinkedList[n];
        Arrays.setAll(g, e -> new LinkedList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }

        for (int i = 0; i < n; i++) {
            if (g[i].size() <= 1) continue;
            LinkedList<Integer> list = new LinkedList<>();
            int sum = 0;
            for (int[] node : g[i]) {
                int res = dfs(i, node[0], node[1]);
                if (res > 0) {
                    list.add(res);
                    sum += res;
                }
            }
            if (list.size() > 1) {
                int res = 0;
                for (Integer num : list) {
                    res += num * (sum - num);
                    sum -= num;
                }
                ans[i] = res;
            }

        }

        return ans;
    }

    private int dfs(int fa, int cur, int val) {
        if (g[cur].size() == 1 && g[cur].getLast()[0] == fa) {
            if (val % signalSpeed == 0) return 1;
            return 0;
        }
        int res = (val % signalSpeed == 0 ? 1 : 0);
        for (int[] son : g[cur]) {
            if (son[0] == fa) continue;
            res += dfs(cur, son[0], val + son[1]);
        }
        return res;
    }

}
