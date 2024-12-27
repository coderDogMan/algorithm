package other.mid;

import java.util.Arrays;

public class 最长递增子序列300 {
    int[] nums;
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, max);
        }
        return ans;


//        this.nums = nums;
//        dp = new int[n];
//        Arrays.fill(dp, -1);
//        int ans = 1;
//        for (int i = 0; i < n; i++) dfs(i);
//        for (int i = 0; i < n; i++) {
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;
    }
    public int dfs(int n) {
        int ans = 1;
        for (int j = 0; j < n; j++) {
            if (nums[j] < nums[n]) {
                if (dp[j] != -1) {
                    ans = Math.max(ans, dp[j] + 1);
                } else {
                    ans = Math.max(ans, dfs(j) + 1);
                }
            }
        }
        dp[n] = ans;
        return dp[n];
    }
}

class Test38 {
    public static void main(String[] args) {
        最长递增子序列300 test = new 最长递增子序列300();
        test.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
//        test.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
//        test.lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
}