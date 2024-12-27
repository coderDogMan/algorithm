package week.weektwo129;

import week.week346.A;

import java.util.Arrays;

public class T3 {
    int MOD = (int) 1e9 + 7;
    int limit;
    int[][][][] memo;
    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new int[zero + 1][one + 1][limit + 1][3];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 0; k <= limit; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        long ans = dfs(zero, one, limit, 2);
        return (int) ans;
    }

    private int dfs(int zero, int one, int curLimit, int last) {
        if (curLimit <= 0) return 0;
        if (zero == 0 && one > curLimit || one == 0 && zero > curLimit) return 0;
        if (zero == 0 && one == 0) {
            return 1;
        }
        if (memo[zero][one][curLimit][last] != -1) return memo[zero][one][curLimit][last];
        long res = 0;
        if (zero > 0)
            res += dfs(zero - 1, one, last == 0 ? curLimit - 1 : limit, 0);
        if (one > 0)
            res += dfs(zero, one - 1, last == 1 ? curLimit - 1 : limit, 1);
        res %= MOD;
        memo[zero][one][curLimit][last] = (int) res;
        return (int) res;
    }
}
class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
//        System.out.println(t3.numberOfStableArrays(1, 2, 1));
        System.out.println(t3.numberOfStableArrays(2, 2, 2));
    }
}
