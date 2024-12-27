package week.week.year2023;

import java.util.Arrays;

public class 阈值距离内邻居最少的城市1334 {

    int[][] dp;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        dp = new int[n][n];
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(g[i], Integer.MAX_VALUE / 2);
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        dp = g;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int max = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && dp[i][j] <= distanceThreshold) cnt++;
            }
            if (cnt <= max) {
                max = cnt;
                ans = i;
            }
        }
        return ans;
    }
}
