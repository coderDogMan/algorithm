package week.gsdc.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TJ {
    static LinkedList<Integer> yezi = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dit = new int[n + 1];
        ArrayList<Integer>[] edge = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            dit[i] = in.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            edge[u].add(v);
            edge[v].add(u);
        }
        long ans = 0;
        dfs1(1, -1, edge);
        for (int i = 0; i < yezi.size(); i++) {
            ans = Math.max(ans, dfs(yezi.get(i), -1,0, edge, dit));
        }
        System.out.println(ans);
    }

    private static void dfs1(int cur, int fa, ArrayList<Integer>[] edge) {
        if (edge[cur].size() == 1 && edge[cur].get(0) == fa) yezi.add(cur);
        for (Integer son : edge[cur]) {
            if (fa == son) continue;
           dfs1(son, cur, edge);
        }
    }


    private static long dfs(int cur, int fa, int len, ArrayList<Integer>[] edge, int[] dit) {
        long val = len * (long)dit[cur];
        for (Integer son : edge[cur]) {
            if (fa == son) continue;
            val += dfs(son, cur, len + 1, edge, dit);
        }
        return val;
    }
}


//8
//9 4 2 7 10 1 6 5
//1 2
//2 3
//1 4
//1 5
//5 6
//5 7
//5 8