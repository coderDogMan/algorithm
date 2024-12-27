package writtentest.alibaba2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 树上脑子 {
    static LinkedList<Integer>[] g;
    static int[] dpMin;
    static int ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        g = new LinkedList[n + 1];
        dpMin = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new LinkedList();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        Arrays.fill(dpMin, Integer.MAX_VALUE);
        dfsInitDpMin(-1, 1);
        for (int i = 1; i <= n; i++) {
            ans = 1;
            dfs(i);
            System.out.print(ans + " ");
        }

    }

    private static void dfs(int cur) {
        if (dpMin[cur] > g.length || dpMin[cur] == Integer.MAX_VALUE) return;
        ans++;
        dfs(dpMin[cur]);
    }

    private static int dfsInitDpMin(int fa, int cur) {
        if (g[cur].size() == 1 && g[cur].getFirst() == fa) {
            return cur;
        }
        int min = Integer.MAX_VALUE;
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            min = Math.min(min, dfsInitDpMin(cur, son));
        }
        dpMin[cur] = min;
        return Math.min(min, cur);
    }
}
