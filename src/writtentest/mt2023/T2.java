package writtentest.mt2023;

import java.util.ArrayList;
import java.util.Scanner;

public class T2 {

    static ArrayList<Integer>[] edge;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edge = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edge[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = i + 1;
            edge[u].add(v);
            edge[v].add(u);
        }
        int u = in.nextInt();
        int v = in.nextInt();
        int max1 = dfs(u, v);
        int max2 = dfs(v, u);
        System.out.println(max1 + max2 - 1);
    }

    private static int dfs(int cur, int fa) {
        int res = 0;
        for (Integer son : edge[cur]) {
            if (son == fa) continue;
            res = Math.max(res, dfs(son, cur));
        }
        return res + 1;
    }
}
