package writtentest.meituan20231007;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
public class T5 {
    static long k;
    static HashSet<Long>[] base = new HashSet[101];
    static LinkedList<Integer>[] g;
    static long[] val;
    static int ans;
    static {
        Arrays.setAll(base, e -> new HashSet());
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    base[i].add(1L * j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        k = in.nextLong();
        val = new long[n + 1];
        g = new LinkedList[n + 1];
        Arrays.setAll(g, e -> new LinkedList<>());
        for (int i = 1; i <= n; i++) {
            val[i] = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        dfs(-1, 1);
        System.out.println(ans % 2 == 0 ? 1 : 0);
    }

    private static HashSet<Long> dfs(int fa, int cur) {
        if (g[cur].size() == 1 && g[cur].getFirst() == fa) {
            if (base[(int) val[cur]].size() >= k) ans++;
            return base[(int) val[cur]];
        }
        HashSet<Long> node = new HashSet<>();
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            HashSet<Long> sonSet = dfs(cur, son);
            val[cur] *= val[son];
            node.addAll(sonSet);
        }
        int[] keys = node.stream().mapToInt(Long::intValue).toArray();
        for (int key : keys) {
            node.add(val[cur] / key);
        }
        if (node.size() >= k) ans++;
        return node;
    }
}
