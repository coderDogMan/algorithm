package week.weektwo111;

import java.util.Arrays;

public class Q4 {
    int k;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        return getCnt(high) - getCnt(low) + check(low);
    }

    private int check(int low) {
        int j = 0;
        int o = 0;
        for (char c : String.valueOf(low).toCharArray()) {
            if ((c - '0') % 2 == 1) {
                j++;
            } else {
                o++;
            }
        }
        return (j == o && (low % k == 0)) ? 1 : 0;
    }

    char[] s;
    int[][][][] memo;
    private int getCnt(int num) {
        s = String.valueOf(num).toCharArray();
        int n = s.length;
        memo = new int[n][10][10][21];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int p = 0; p < 10; p++) {
                    Arrays.fill(memo[i][j][p], -1);
                }
            }
        }
        return dfs(0, 0, 0,0, true, false);
    }

    private int dfs(int i, int j, int o, int num, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            if (isNum) {
                if (j == o) {
                    if (num % k == 0) return 1;
                }
            }
            return 0;
        }
        if (!isLimit && isNum && memo[i][j][o][num] != -1) {
            return memo[i][j][o][num];
        }
        int res = 0;
        if (!isNum) {
            res = dfs(i + 1, j, o, num, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            res += dfs(i + 1, j + (d % 2 == 1 ? 1 : 0), o + (d % 2 == 0 ? 1 : 0), (num * 10 + d) % k, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            memo[i][j][o][num] = res;
        }
        return res;
    }
}
