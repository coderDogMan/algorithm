package week.week.year2023;

import java.util.Arrays;

public class 使数组变美的最小增量运算数2919 {
    int[] nums;
    int k;
    long[] memo;
    public long minIncrementOperations(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        memo = new long[n];
        Arrays.fill(memo, -1);
        this.k = k;
        return Math.min(dfs(0), Math.min(dfs(1), dfs(2)));
    }

    private long dfs(int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        long res = Long.MAX_VALUE;
        res = Math.min(dfs(i + 1), Math.min(dfs(i + 2), dfs(i + 3))) + Math.max(k - nums[i], 0);
        memo[i] = res;
        return res;
    }
}
