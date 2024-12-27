package other.mid;

import java.util.Scanner;

public class 最长公共子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
