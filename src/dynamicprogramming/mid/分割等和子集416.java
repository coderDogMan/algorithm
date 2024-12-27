package dynamicprogramming.mid;

public class 分割等和子集416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int j = 1; j < target; j++) {
            if (j + 1 >= nums[0]) dp[0][j] = nums[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]]), dp[i - 1][j - nums[i]] + nums[i]);
            }
        }
        return dp[n][target] == target;
    }
}

class Test1 {
    public static void main(String[] args) {
        分割等和子集416 test = new 分割等和子集416();
        test.canPartition(new int[]{1,2,3,2});
        test.canPartition(new int[]{2,2,3,5});
    }
}