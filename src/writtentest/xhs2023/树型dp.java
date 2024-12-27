package writtentest.xhs2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 树型dp {
    static int N = 200001;
    static LinkedList<Integer>[] g;
    static int[] val;
    static boolean[] nums = new boolean[N];
    static int ans;
    static {
        for (int i = 2; i < N; i++) {
            if (nums[i]) continue;
            nums[i] = false;
            for (int j = 2; j * i < N && (j * i) > 0; j++) {
                nums[j * i] = true;
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        g = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) g[i] = new LinkedList();
        val = new int[n + 1];
        for (int i = 1; i <= n; i++) val[i] = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        dfs(-1, 1);
        System.out.println(ans);
    }

    private static void dfs(int fa, int cur) {
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            dfs(cur, son);
            if (nums[val[son] + val[cur]] == false) ans++;
        }
    }
}
