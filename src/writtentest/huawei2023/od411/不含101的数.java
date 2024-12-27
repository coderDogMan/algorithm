package writtentest.huawei2023.od411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 不含101的数 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int l = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        int resR = get(r);
        int resL = get(l - 1);
        System.out.println(resR - resL);

    }
    static char[] s;
    static int[][][] memo;

    private static int get(Integer n) {
        s = Integer.toBinaryString(n).toCharArray();
        int m = s.length;
        memo = new int[m][2][2];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i][0], -1);
            Arrays.fill(memo[i][1], -1);
        }
        
        return f(0, -1, -1, true, false);
    }

    private static int f(int i, int pre1, int pre2, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][pre1][pre2] != -1) {
            return memo[i][pre1][pre2];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, 0, 0, false, false);
        }
        int up = isLimit ? s[i] - '0' : 1;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (pre1 == 1 && pre2 == 0 && d == 1) continue;
            res += f(i + 1, pre2, d, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            memo[i][pre1][pre2] = res;
        }
        return res;
    }
}
