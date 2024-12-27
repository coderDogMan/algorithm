package writtentest.baidu2023;

import java.util.ArrayList;
import java.util.Scanner;

public class 零树 {
    static int[] dit;
    static ArrayList<Integer>[] edge;
    static int[][] vals;
    static int[][] lazy;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dit = new int[n + 1];
        used = new boolean[n + 1];
        edge = new ArrayList[n + 1];
        vals = new int[n + 1][2];
        lazy = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dit[i] = in.nextInt();
            vals[i][0] = getN(dit[i], 2);
            vals[i][1] = getN(dit[i], 5);
        }
        for (int i = 0; i <= n; i++)
            edge[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            edge[u].add(v);
            edge[v].add(u);
        }
        int q = in.nextInt();
        while (q-- > 0) {
            int t = in.nextInt();
            int g = in.nextInt();
            lazy[t][0] += getN(g, 2);
            lazy[t][1] += getN(g, 5);
        }
        dfs1(1);
        dfs2(1);
        for (int i = 1; i <= n; i++) {
            System.out.print(Math.min(vals[i][0], vals[i][1]) + " ");
        }

    }
    //自底向上
    private static void dfs2(int root) {
        used[root] = false;
        for (Integer son : edge[root]) {
            if (used[son]) {
                dfs2(son);
                vals[root][0] += vals[son][0];
                vals[root][1] += vals[son][1];
            }
        }
    }

    //下传lazy
    private static void dfs1(int root) {
        int tow = lazy[root][0];
        int five = lazy[root][1];
        vals[root][0] += tow;
        vals[root][1] += five;
        used[root] = true;
        for (Integer son : edge[root]) {
            if (!used[son]) {
                lazy[son][0] += tow;
                lazy[son][1] += five;
                dfs1(son);
            }
        }
    }

    private static int getN(int a, int b) {
        int ans = 0;
        while ((a % b) == 0) {
            ans++;
            a /= b;
        }
        return ans;
    }
}
