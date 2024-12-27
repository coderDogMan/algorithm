package week.week.year2023;

import java.util.Arrays;

public class 数字1的个数233 {
    int[][] memo;
    char[] s;
    int n;
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        this.s = s.toCharArray();
        this.n = n;
        int m = s.length();
        memo = new int[m][10];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1);
        return f(0, 0, true, false);
    }

    private int f(int i, int cnt, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return cnt;
        }
        if (!isLimit && isNum && memo[i][cnt] != -1) {
            return memo[i][cnt];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, cnt, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (d == 1) {
                res += f(i + 1, cnt + 1, isLimit && d == up, true);
            } else {
                res += f(i + 1, cnt, isLimit && d == up, true);
            }

        }
        if (!isLimit && isNum)
            memo[i][cnt] = res;
        return res;
    }

}

class Test31 {
    public static void main(String[] args) {
        数字1的个数233 test = new 数字1的个数233();
        test.countDigitOne(13);
    }
}