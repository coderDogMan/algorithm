package writtentest.meituan2023;

import java.util.ArrayList;
import java.util.Scanner;

public class TFirst4 {
    static int N = 200;
    // u -> v && v -> u
    static ArrayList<Edge>[] g = new ArrayList[N];
    //节点 i 的权值
    static int[] dis = new int[N];
    static int[] sum = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            dis[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++)
            g[i] = new ArrayList<Edge>();
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(new Edge(u, v));
            g[v].add(new Edge(v, u));
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, 0, dis[i]);
        }

        for (int i = 1; i <= n; i++)
            System.out.print(sum[i] + " ");
    }

    private static void dfs(int u, int fa, int d) {
        if (d < 0) return;
        sum[u]++;
        for (Edge edge : g[u]) {
            if (edge.v == fa) continue;
            dfs(edge.v, u, d - 1);
        }

    }

    static class Edge {
        int u, v;
        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
