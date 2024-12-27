package writtentest.alibaba2023;

import java.util.Scanner;

public class 排列的排列 {
    public static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x > n) continue;
            dp[x]++;
        }

        for (int i = 2; i < n; i++) {
            if (dp[i - 1] != 0) {
                dp[i] = (dp[i] * dp[i - 1]) % MOD;
            } else {
                dp[i] = 0;
            }
        }
        long ans = 0;
        for (long i : dp) {
            ans = (ans + i) % MOD;
        }
        System.out.println(ans);
    }
}
