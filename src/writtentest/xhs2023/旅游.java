package writtentest.xhs2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 旅游 {
    static long[] happy;
    static long[] time;
    static ArrayList<Long[]>[] g;
    static long ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        happy = new long[n + 1];
        time = new long[n + 1];
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList();
        }
        for (int i = 1; i <= n; i++) {
            happy[i] = in.nextInt();
            ans = Math.max(ans, happy[i]);
        }
        for (int i = 1; i <= n; i++) {
            time[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g[u].add(new Long[]{time[v] + w, happy[v]});
            g[v].add(new Long[]{time[u] + w, happy[u]});
        }
        // g[i] 花的时间 快乐值
        for (int i = 1; i <= n; i++) {
            Collections.sort(g[i], (a, b) -> {
                return a[0].compareTo(b[0]);
            });
            if (time[i] <= k) {
                ans = Math.max(ans, happy[i]);
            }
            if (g[i].size() == 1 && time[i] + g[i].get(0)[0] <= k) {
                ans = Math.max(ans, happy[i] +  g[i].get(0)[1]);
            }
            for (int x = 1; x < g[i].size(); x++) {
                int l = find(i, x, k);
                if (l == -1) {
                    g[i].get(x)[1] = Math.max(g[i].get(x)[1], g[i].get(x - 1)[1]);
                    continue;
                }
//                if (g[i].get(x)[0] + g[i].get(l)[0] + time[i] <= k)
                    ans = Math.max(ans, g[i].get(x)[1] + g[i].get(l)[1] + happy[i]);
                g[i].get(x)[1] = Math.max(g[i].get(x)[1], g[i].get(x - 1)[1]);
            }
        }
        System.out.println(ans);
    }

    private static int find(int i, int x, int k) {
        int l = 0;
        int r = x - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (g[i].get(x)[0] + g[i].get(mid)[0] + time[i] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }


}
