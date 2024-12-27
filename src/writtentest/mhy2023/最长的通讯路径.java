package writtentest.mhy2023;

import java.util.ArrayList;
import java.util.Scanner;

public class 最长的通讯路径 {

    static ArrayList<int[]>[] edge;
    static boolean[] used;
    static int ans;
    static int prev = -1;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        used = new boolean[n + 1];
        edge = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            //红 黑
            int color = "R".equals(in.next()) ? 0 : 1;
            edge[u].add(new int[]{v, color});
            edge[v].add(new int[]{u, color});
        }
        dfs(1);
        System.out.println(ans);
    }

    private static int[] dfs(int root) {
        used[root] = true;
        int r = 0, b = 0;
        for (int[] son : edge[root]) {
            if (used[son[0]]) {
                continue;
            }
            int[] val = dfs(son[0]);
            if (son[1] == 0) {
                r = Math.max(r, val[1] + 1);
            } else {
                b = Math.max(b, val[0] + 1);
            }
        }
        ans = Math.max(ans, r + b);
        return new int[]{r, b};
    }
}
