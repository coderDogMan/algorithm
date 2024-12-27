//package week.week388;
//
//public class T4 {
//    public long maximumStrength(int[] nums, int k) {
//        int n = nums.length;
//        long[][] dp = new long[k + 1][n + 1];
//        long[] sum = new long[n + 1];
//        for (int i = 0; i < n; i++) {
//            sum[i + 1] = sum[i] + nums[i];
//        }
//        // dp[i][j] = dp[i][j - 1]
//        //选
//        // dp[i][j] = dp[i - 1][j - 1] + nums[j] * w
//        // dp[i][j] = dp[i - 1][j - 2] + (nums[j] + nums[j - 1]) * w
//        // dp[i][j] = dp[i - 1][j - 3] + (nums[j] + nums[j - 1] + nums[j - 2]) * w
//        // j - 1  ----  i - 1
//        for (int i = 1; i <= k; i++) {
//            for (int j = i; j <= n - k + i; j++) {
//                for (int L = 1; L <= j - 1; L++) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - L][j - 1]) + (sum[j] - sum[j - L] * ((-1) * sum[i] * (x - i + 1)));
//                }
//            }
//        }
//        return dp[n][k];
//
//
//
//    }
//
//}
