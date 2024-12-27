package writtentest.mt2023;

import java.util.ArrayList;
import java.util.Scanner;

public class RGB树 {
    static ArrayList<Integer>[] edge;
    static String s;
    static int[][] dp;
    static int sumR;
    static int sumG;
    static int sumB;
    static int ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edge = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) edge[i] = new ArrayList();
        for (int i = 2; i <= n; i++) {
            int v = in.nextInt();
            edge[i].add(v);
            edge[v].add(i);
        }
        s = in.next();
        dp = new int[n + 1][3];
        dfs1(1, -1);
        sumR = dp[1][0];
        sumG = dp[1][1];
        sumB = dp[1][2];
        dfs2(1, -1);
        System.out.println(ans);
    }

    private static void dfs2(int cur, int fa) {
        for (Integer son : edge[cur]) {
            if (son == fa) continue;
            int R = sumR - dp[son][0];
            int G = sumG - dp[son][1];
            int B = sumB - dp[son][2];
            if (R > 0 && G > 0 && B > 0 && dp[son][0] > 0 && dp[son][1] > 0 && dp[son][2] > 0) ans++;
            dfs2(son, cur);
        }

    }

    private static void dfs1(int cur, int fa) {
        if (s.charAt(cur - 1) == 'R') {
            dp[cur][0] = 1;
        } else if (s.charAt(cur - 1) == 'G') {
            dp[cur][1] = 1;
        } else {
            dp[cur][2] = 1;
        }
        for (Integer son : edge[cur]) {
            if (son == fa) continue;
            dfs1(son, cur);
            dp[cur][0] += dp[son][0];
            dp[cur][1] += dp[son][1];
            dp[cur][2] += dp[son][2];
        }
    }
}
