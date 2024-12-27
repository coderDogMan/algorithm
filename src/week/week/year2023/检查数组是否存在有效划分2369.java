package week.week.year2023;

public class 检查数组是否存在有效划分2369 {


    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = false;
        for (int i = 2; i <= n; i++) {
            if (nums[i - 1] == nums[i - 2] && dp[i - 2]) {
                dp[i] = true;
            } else if ( i >= 3 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp[i - 3]) {
                dp[i] = true;
            } else if (i >= 3 && nums[i - 1] - 1 == nums[i - 2] && nums[i - 2] - 1 == nums[i - 3] && dp[i - 3]) {
                dp[i] = true;
            }
        }
        return dp[n];
    }
}

class Test54 {
    public static void main(String[] args) {
        检查数组是否存在有效划分2369 test = new 检查数组是否存在有效划分2369();
        test.validPartition(new int[] {4,4,4,5,6});
    }
}
