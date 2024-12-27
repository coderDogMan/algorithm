package week.week.year2023;

public class 有效的快递序列数目1359 {
    static final long MOD = (long) 1e9 + 7;
    static long[] dp;

    static {
        dp = new long[501];
        dp[1] = 1;
        for (int i = 2; i <= 500; i++) {
            long a = 2 * (i - 1) + 1;
            long b = a * (a - 1) / 2 + a;
            dp[i] = dp[i - 1] * b % MOD;
        }
    }

    public int countOrders(int n) {
        return (int) dp[n];
    }

}
