package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.HashMap;

public class 修改数组后最大化数组中的连续元素数目3041 {

    public int maxSelectedElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[nums[n - 1] + 2];
        dp[nums[0]] = 1;
        dp[nums[0] + 1] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[nums[i] + 1] = dp[nums[i]] + 1;
            dp[nums[i]] = dp[nums[i] - 1] + 1;
            ans = Math.max(ans, dp[nums[i]]);
        }

        return ans;

    }

}
