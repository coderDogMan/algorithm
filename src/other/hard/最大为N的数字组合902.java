package other.hard;

import java.util.Arrays;

public class 最大为N的数字组合902 {
    char[] s;
    int[] dp;
    String[] digits;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = String.valueOf(n).toCharArray();
        dp = new int[s.length];
        Arrays.fill(dp, -1);
        this.digits = digits;
        return dfs(0, true, false);
    }

    private int dfs(int i, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i] != -1) return dp[i];
        int res = 0;
        if (!isNum) {
            res += dfs(i + 1, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int j = 0; j < digits.length; j++) {
            int val = Integer.parseInt(digits[j]);
            if (val > up) break;
            res += dfs(i + 1, isLimit && val == (s[i] - '0'), true);
        }
        if (!isLimit && isNum) dp[i] = res;
        return res;
    }
}

class Test6 {
    public static void main(String[] args) {
        最大为N的数字组合902 test = new 最大为N的数字组合902();
        System.out.println(test.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
    }
}