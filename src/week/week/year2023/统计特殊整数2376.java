package week.week.year2023;

import java.util.Arrays;

public class 统计特殊整数2376 {
    char[] s;
    int[][] memo;
    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        memo = new int[s.length][1 << 10];
        for (int i = 0; i < s.length; i++)
            Arrays.fill(memo[i], -1);
        return dfs(0, 0, true, false);
    }

    private int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (isNum && !isLimit && memo[i][mask] != -1) return memo[i][mask];
        int res = 0;
        if (!isNum) {
            res = dfs(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if ((mask & (1 << d)) == 0) {
                res += dfs(i + 1, (mask & (1 << d)), isLimit && up == d, true);
            }
        }
        if (isNum && !isLimit) {
            memo[i][mask] = res;
        }
        return res;

    }
}
