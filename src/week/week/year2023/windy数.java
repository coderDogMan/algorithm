package week.week.year2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class windy数 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        System.out.println(get(b) - get(a - 1));
    }

    static int[][] memo;
    static char[] s;

    private static int get(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memo = new int[m][10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0, true, false);

    }

    private static int f(int i, int pre, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][pre] != -1) {
            return memo[i][pre];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, pre, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (!isNum || Math.abs(pre - d) >= 2) {
                res += f(i + 1, d, isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][pre] = res;
        }
        return res;
    }
}
