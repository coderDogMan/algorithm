package week.week.year2023;

import java.util.Arrays;

public class 至少有1位重复的数字1012 {
    char[] s;
    int[][] memo;
    public int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return n - f(0, 0, true, false);

    }

    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isLimit && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if ((mask & (1 << d)) == 0) {
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }
}
