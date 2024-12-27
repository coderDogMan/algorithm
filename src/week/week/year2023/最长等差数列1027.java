package week.week.year2023;

public class 最长等差数列1027 {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j] + 500;
                if (dp[i][diff] == 0) {
                    dp[i][diff] = dp[j][diff] + 1;
                }
                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans + 1;
    }
}

class Test19 {
    public static void main(String[] args) {
        最长等差数列1027 test = new 最长等差数列1027();
        test.longestArithSeqLength(new int[] {3,6,9,12});
    }
}