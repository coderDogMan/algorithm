package week.week.year2023;

import java.util.Arrays;

public class 重新排列后包含指定子字符串的字符串数目2930 {
    int MOD = (int) 1e9 + 7;
    int[][][][] memo;
    public int stringCount(int n) {
        memo = new int[n + 1][2][3][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) Arrays.fill(memo[i][j][k], -1);
            }
        }
        return dfs(n, 1, 2, 1);

    }

    private int dfs(int i, int l, int e, int t) {
        if (i == 0) {
            if (l == 0 && e == 0 && t == 0) return 1;
            return 0;
        }
        if (memo[i][l][e][t] != -1) return memo[i][l][e][t];
        long res = 0;
        res += dfs(i - 1, 0, e, t);
        res += dfs(i - 1, l, Math.max(0, e - 1), t);
        res += dfs(i - 1, l, e, 0);
        res = (res + dfs(i - 1, l , e, t) * 23L) % MOD;
        memo[i][l][e][t] = (int) res % MOD;
        return memo[i][l][e][t];
    }
}
class Test90 {
    public static void main(String[] args) {
        重新排列后包含指定子字符串的字符串数目2930 test = new 重新排列后包含指定子字符串的字符串数目2930();
        System.out.println(test.stringCount(4));
    }
}
