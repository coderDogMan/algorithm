package writtentest.meituan2023;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 树上染色 {

    static LinkedList<Integer>[] g;
    static long[] val;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        val = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            val[i] = in.nextInt();
        }
        g = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new LinkedList();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
        }
        int[] ans = dfs(1);
        System.out.println(Math.max(ans[0], ans[1]));

    }

    // a[0] 不选 a[1] 选
    private static int[] dfs(int cur) {
        long curVal = val[cur];
        int[] res = new int[2];
        HashMap<Integer, int[]> map = new HashMap<>();
        for (Integer son : g[cur]) {
            int[] sonRes = dfs(son);
            map.put(son, sonRes);
            res[0] += Math.max(sonRes[0], sonRes[1]);
        }
        for (Integer son : g[cur]) {
            if (check(curVal * val[son])) {
                res[1] = Math.max(res[1], res[0] - Math.max(map.get(son)[0], map.get(son)[1]) + map.get(son)[0] + 2);
            }
        }
        return new int[]{res[0], res[1]};
    }

    private static boolean check(long val) {
        long x = (long) Math.sqrt(val);
        return x * x == val;
    }
}
