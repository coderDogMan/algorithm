package writtentest.pdd2023;


import java.util.Scanner;

public class 塔子哥的01排列 {
    public static int MOD = (int) 1e9 + 7;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        memo = new int[n][2];
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][0]) % MOD;
        }
        System.out.println((dp[n - 1][0] + dp[n - 1][1]) % MOD);



//        for (int i = 0; i < n; i++)
//            Arrays.fill(memo[i], -1);
//        System.out.println(dfs(n - 1, 1));

    }

    private static int dfs(int i, int last) {
        if (i == 0) {
            if (last == 0) return 1;
            return 2;
        }
        if (memo[i][last] != -1) return memo[i][last];
        long res = 0;
        res += dfs(i - 1, 1);
        if (last == 1)
            res += dfs(i - 1, 0);
        memo[i][last] = (int) (res % MOD);
        return memo[i][last];
    }
}
