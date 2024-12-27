package week.week.year2023;

import java.util.Arrays;
import java.util.List;

public class 和为目标值的最长子序列的长度2915 {

    List<Integer> nums;
    int[][] memo;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        this.nums = nums;
        int ans = dfs(0, target);
        memo = new int[nums.size()][target + 1];
        for (int i = 0; i < nums.size(); i++) Arrays.fill(memo[i], -1);
        return ans > 0 ? ans : -1;
    }

    private int dfs(int i, int target) {
        if (i >= nums.size()) {
            if (target == 0) return 0;
            return Integer.MIN_VALUE;
        }
        if (target == 0) return 0;
        if (target < 0) return Integer.MIN_VALUE;
        if (memo[i][target] != -1) return memo[i][target];
        int res1 = dfs(i + 1, target - nums.get(i)) + 1;
        int res2 = dfs(i + 1, target);
        memo[i][target] = Math.max(res1, res2);
        return memo[i][target];
    }
}
