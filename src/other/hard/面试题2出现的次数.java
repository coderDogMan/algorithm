package other.hard;

import java.util.Arrays;

public class 面试题2出现的次数 {
    char[] s;
    int[][] dp;
    public int numberOf2sInRange(int n) {
        s = String.valueOf(n).toCharArray();
        dp = new int[s.length][10];
        for (int i = 0; i < s.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, true, false, 0);

    }

    private int dfs(int i, boolean isLimit, boolean isNum, int tow) {
        if (i == s.length) return tow;
        int res = 0;
        if (!isLimit && isNum && dp[i][tow] != -1) return dp[i][tow];
        if (!isNum) {
            res += dfs(i + 1, false, false, tow);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int j = isNum ? 0 : 1; j <= up; j++) {
            res += dfs(i + 1, isLimit && j == up, true, tow + (j == 2 ? 1 : 0));
        }
        if (!isLimit && isNum) dp[i][tow] = res;
        return res;
    }
}

class Test10 {
    public static void main(String[] args) {
        面试题2出现的次数 test = new 面试题2出现的次数();
        System.out.println(test.numberOf2sInRange(5));
        System.out.println(test.numberOf2sInRange(100));
    }

}