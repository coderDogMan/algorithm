package dynamicprogramming.hrad;

import java.util.Arrays;

public class 剑指OfferII094最少回文分割 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(map[i], true);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    map[i][j] = map[i + 1][j - 1];
                } else {
                    map[i][j] = false;
                }
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (map[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j <= i; j++) {
                    if (map[j][i]){
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}

class Test4 {
    public static void main(String[] args) {
        剑指OfferII094最少回文分割 test = new 剑指OfferII094最少回文分割();
        int i = test.minCut("cdd");
    }
}
