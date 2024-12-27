package week.week.year2023;

public class 解决智力问题2140 {
    public long mostPoints(int[][] questions) {
        long ans = 0;
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            int point = questions[i][0];
            int brainpower = questions[i][1];
            if (i + brainpower + 1 < n) {
                dp[i] = Math.max(point + dp[i + brainpower + 1], dp[i + 1]);
            } else {
                dp[i] = Math.max(point,dp[i - 1]);
            }
        }
        return dp[0];
    }
}
