package week.week377;

import java.util.Arrays;
import java.util.LinkedList;

public class T3 {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        int[][] dp = new int[26][26];
        int[][] g = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            g[original[i] - 'a'][changed[i] - 'a'] = Math.min(g[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int f = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (f != t) {
                if (dp[f][t] >= Integer.MAX_VALUE / 2) return -1;
                ans += dp[f][t];
            }
        }
        return ans;
    }

}
