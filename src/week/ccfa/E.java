package week.ccfa;

import java.util.Scanner;

/**
 * @Author: min
 * @Date:
 */
public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mod = (int) 1e9 + 7;
        int n = in.nextInt();
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        System.out.println(dp[n] * dp[n] % mod);
    }
}
