package writtentest.meituan2023;


import java.util.*;

public class T5 {
    static int[][] tree;
    static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tree = new int[n + 1][3];
        dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int fa = in.nextInt();
            if (tree[fa][0] == 0) {
                tree[fa][0] = i;
            } else {
                tree[fa][1] = i;
            }
        }
        for (int i = 1; i <= n; i++)
            tree[i][2] = in.nextInt();
        dfs(1);
        System.out.println(dp[1]);

    }

    private static void dfs(int root) {
        if (dp[root] != 0) {
            return;
        }
        if (tree[root][0] == 0 && tree[root][0] == 0){
            dp[root] = 1;
            return;
        }
        if (tree[root][0] != 0 && tree[root][1] == 0) {
            dfs(tree[root][0]);
            dp[root] = dp[tree[root][0]];
            return;
        }
        if (tree[root][0] == 0 && tree[root][1] != 0) {
            dfs(tree[root][1]);
            dp[root] = dp[tree[root][1]];
            return;
        }
        dfs(tree[root][0]);
        dfs(tree[root][1]);
        if (tree[root][2] == 1) {
            dp[root] = dp[tree[root][0]] + dp[tree[root][1]];
        } else {
            dp[root] = dp[tree[root][0]] ^ dp[tree[root][1]];
        }
    }
}
