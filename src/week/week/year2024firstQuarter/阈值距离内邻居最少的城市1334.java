package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.LinkedList;

public class 阈值距离内邻居最少的城市1334 {

    LinkedList<int[]>[] g;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        g = new LinkedList[n];
        Arrays.setAll(g, e -> new LinkedList<>());
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        for (int[] e : edges) {
            dp[e[0]][e[1]] = e[2];
            dp[e[1]][e[0]] = e[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int max = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (dp[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= max) {
                ans = i;
                max = cnt;
            }
        }
        return ans;
    }
}
class Test22 {
    public static void main(String[] args) {
        阈值距离内邻居最少的城市1334 test = new 阈值距离内邻居最少的城市1334();
        test.findTheCity(6, new int[][]{{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}}, 20);
//        test.findTheCity(5, new int[][]{{0,1,3},{1,2,1}, {1,3,4},{2,3,1}}, 4);
//        test.findTheCity(5, new int[][]{{0,1,2},{0,4,8}, {1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2);
    }
}
