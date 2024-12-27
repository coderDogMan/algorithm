package week.week.year2023;

public class 给Nx3网格图涂色的方案数1411 {

    public int numOfWays(int n) {
        int MOD = (int) 1e9 + 7;
        long[][] ans = new long[5000 + 1][2];
        ans[1][0] = 6;
        ans[1][1] = 6;
        for (int i = 2; i <= 5000; i++) {
            ans[i][0] = (3 * ans[i - 1][0] + 2 * ans[i][2]) % MOD;
            ans[i][1] = (2 * ans[i - 1][0] + 2 * ans[i - 1][1]) % MOD;
        }
        return (int) ((ans[n][0] + ans[n][1]) % MOD);
    }

}
