package week.week.year2023;

import java.util.Arrays;

public class 完成任务的最少工作时间段1986 {

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int m = 1 << n;
        int[] sum = new int[m];
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = 1 << i; j < k; j++) {
                sum[j | k] = sum[j] + tasks[i];
            }
        }
        for (int s = 0; s < m; s++) {
            for (int sub = s; sub > 0; sub = (sub - 1) & s) {
                if (sum[sub] <= sessionTime)
                    dp[s] = Math.min(dp[s], dp[s ^ sub] + 1);
            }
        }
        return dp[m - 1];
    }


}
