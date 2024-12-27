package week.week.year2023;

import java.util.Arrays;

public class 统计整数数目2719 {

    public static final int MOD = (int) 1e9 + 7;
    int min_sum;
    int max_sum;
    char[] s;
    long[][] memo;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.min_sum = min_sum;
        this.max_sum = max_sum;
        return (int) ((cnt(num2) - cnt(num1) + check(num1)) % MOD) ;
    }

    private int check(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += (c - '0');
        }
        return (sum <= max_sum && sum >= min_sum) ? 1 : 0;
    }

    private long cnt(String str) {
        s = str.toCharArray();
        int n = s.length;
        memo = new long[n][200];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0,true, false);
    }

    private long dfs(int i, int sum, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? (sum >= min_sum ? 1 : 0) : 0;
//            return sum >= min_sum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][sum] != -1) return memo[i][sum];

        long res = 0;
        if (!isNum) {
            res = dfs(i + 1, sum,false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (sum + d > max_sum) break;
            res = (res + dfs(i + 1, sum + d,isLimit && d == up, true));
        }
        if (!isLimit && isNum) memo[i][sum] = (int) (res % MOD);

        return res % MOD;
    }
}
