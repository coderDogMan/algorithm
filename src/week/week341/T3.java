package week.week341;

public class T3 {
    public int addMinimum(String word) {
        int n = word.length();
        int[] dp = new int[n];
        // dp[i] 第i个字符最少修改
        dp[0] = 2;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) - 1 == word.charAt(i - 1)) {
                dp[i] = dp[i - 1] - 1;
            } else if (word.charAt(i) - 2 == word.charAt(i - 1)) {
                dp[i] = dp[i - 1] - 1;
            }
            else {
                dp[i] = dp[i - 1] + 2;
            }
        }
        return dp[n - 1];
    }
}
