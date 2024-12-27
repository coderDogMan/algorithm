package writtentest.qz4399;

import java.util.Scanner;

public class 硬币 {
    static long[] dp = new long[51];
    static {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 50; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        System.out.println(dp[n]);
    }
}
