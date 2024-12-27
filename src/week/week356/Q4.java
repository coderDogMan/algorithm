package week.week356;

import java.util.Arrays;

public class Q4 {

    private static final int MOD = (int) 1e9 + 7;

    public int countSteppingNumbers(String low, String high) {

        return (calc(high) - calc(low)) % MOD + (valid(low) ? 1 : 0);

    }

    private boolean valid(String low) {
        if (low.length() < 2) return true;
        for (int i = 1; i < low.length(); i++) {
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) > 1) {
                return false;
            }
        }
        return true;
    }


    char[] s;
    int[][] memo;
    private int calc(String s) {
        this.s = s.toCharArray();
        int m = s.length();
        memo = new int[m][10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0, true, false);
    }

    private int f(int i, int pre, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isLimit ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][pre] != -1)
            return memo[i][pre];
        int res = 0;
        if (!isNum) {
            res = f(i + 1, pre, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (!isNum || Math.abs(d - pre) == 1)
                res = (res + f(i + 1, d, isLimit & d != s[i] - '0', true)) % MOD;
        }
        if (!isLimit && isNum )
            memo[i][pre] = res;
        return res;
    }

}


class Test4 {
    public static void main(String[] args) {
        Q4 test = new Q4();
        test.countSteppingNumbers("1", "11");
    }
}