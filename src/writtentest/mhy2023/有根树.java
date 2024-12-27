package writtentest.mhy2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 有根树 {
    static LinkedList<Integer>[] g;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        g = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++)
            g[i] = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        long ans = dfs(-1, 1, k);
        System.out.println(ans);
    }

    private static long dfs(int fa, int cur, int k) {
        if (k > 0 && g[cur].size() == 1 && g[cur].getFirst() == fa) return 1 + k;
        if (k < 0 && g[cur].size() == 1 && g[cur].getFirst() == fa) return 0;
        if (k == 0 && g[cur].size() == 1 && g[cur].getFirst() == fa) return 1;
        long res = 0;
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            res += dfs(cur, son, k - 1);
        }
        return res + 1;
    }
}
