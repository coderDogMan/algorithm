package writtentest.rouyao;

import java.util.LinkedList;
import java.util.Scanner;

public class 探险 {

    static LinkedList<Integer>[] g;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        g = new LinkedList[n];
        for (int i = 0; i <= n; i++) {
            g[i] = new LinkedList();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        dfs(0, -1);

    }

    private static void dfs(int i, int i1) {
    }
}
