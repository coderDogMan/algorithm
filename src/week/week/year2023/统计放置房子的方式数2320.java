package week.week.year2023;

public class 统计放置房子的方式数2320 {

    public static final int MOD = (int) 1e9 + 7;
//
//    public int countHousePlacements(int n) {
//        //长度为n 的放置数
//
//        dfs(n);
//    }
//
//    private long dfs(int i) {
//        if (i < 0) return 1;
//
//        long res = 0;
//        res = dfs(i - 1);
//        res += dfs(i - 2)
//
//    }

    public int countHousePlacements(int n) {
        long[][] dp = new long[n + 1][2];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(dp[i], 1);
//        }
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0]) % MOD;
            dp[i][1] = (dp[i - 1][1] + dp[i - 2][1]) % MOD;

        }
        return (int) ((dp[n][0] * dp[n][1]) % MOD);

    }

}
class Test52 {
    public static void main(String[] args) {
        统计放置房子的方式数2320 test = new 统计放置房子的方式数2320();
        test.countHousePlacements(2);
    }
}
