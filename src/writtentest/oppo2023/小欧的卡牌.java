package writtentest.oppo2023;

import java.util.Scanner;

public class 小欧的卡牌 {
    static final long MOD = (int) 1e9 + 7;
    static int[] L;
    static int[] R;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        L = new int[n];
        R = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = in.nextInt() % 3;
            R[i] = in.nextInt() % 3;
        }
        dp = new long[n + 1][3];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = (dp[i - 1][(j + L[i - 1] + 3) % 3] + dp[i - 1][(j + R[i - 1] + 3) % 3]) % MOD;
            }
        }
        System.out.println(dp[n][0]);
    }
//    private static long dfs(int i, int mod) {
//        if (i < 0) return 0;
//
////        if (dp[i][mod] != -1) return dp[i][mod];
//        long res = 0;
//
//        if (L[i] % mod == 0) {
//            res += dfs(i - 1, 3);
//        } else if (L[i] % mod == 1) {
//            res += dfs(i - 1, 2);
//        } else if (L[i] % mod == 2) {
//            res += dfs(i - 1, 1);
//        }
//
//        if (R[i] % mod == 0) {
//            res += dfs(i - 1, 3);
//        } else if (R[i] % mod == 1) {
//            res += dfs(i - 1, 2);
//        } else if (R[i] % mod == 2) {
//            res += dfs(i - 1, 1);
//        }
//
////        dp[i][mod] = res;
//        return res;
//    }
}
