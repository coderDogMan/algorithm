package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 相同分数的最大操作数目II3040 {

    int n;
    int[] nums;
    int[][] memo;
    public int maxOperations(int[] nums) {
        n = nums.length;
        this.nums = nums;
        return Math.max(helper(2, n - 1, nums[0] + nums[1]), Math.max(helper(1, n - 2, nums[0] + nums[n - 1]), helper(0, n - 3, nums[n - 1] + nums[n - 2])));
    }

    private int helper(int l, int r, int val) {
        memo = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return dfs(l, r, val) + 1;
    }

    private int dfs(int l, int r, int val) {
        if (l >= r) {
            return 0;
        }
        if (memo[l][r] != -1) return memo[l][r];
        int res = 0;
        if (nums[l] + nums[l + 1] == val) {
            res = Math.max(res, dfs(l + 2, r, val) + 1);
        }
        if (nums[l] + nums[r] == val) {
            res = Math.max(res, dfs(l + 1, r - 1, val) + 1);
        }
        if (nums[r] + nums[r - 1] == val) {
            res = Math.max(res, dfs(l, r - 2, val) + 1);
        }
        memo[l][r] = res;
        return res;

    }
}
