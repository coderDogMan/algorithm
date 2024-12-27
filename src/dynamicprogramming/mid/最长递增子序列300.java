package dynamicprogramming.mid;

import java.util.Arrays;

public class 最长递增子序列300 {
    public int lengthOfLIS(int[] nums) {
        //dp[i] 以i 结尾的最长递增子序列
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}

class Test {
    public static void main(String[] args) {
        最长递增子序列300 test = new 最长递增子序列300();
        test.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}