package week.week.year2023;

import java.util.Arrays;

public class 访问数组中的位置使分数最大2786 {

    int[] nums;
    int x;
    long[][] memo;
    public long maxScore(int[] nums, int x) {
        this.nums = nums;
        this.x = x;
        int n = nums.length;
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 0 是偶数 1 是奇数
        return dfs(1, nums[0] % 2) + nums[0];
    }

    private long dfs(int i, int mod) {
        if (i == nums.length) return 0;
        if (memo[i][mod] != -1) return memo[i][mod];
        long res = Integer.MAX_VALUE;
        res = dfs(i + 1, mod);
        if (mod == nums[i] % 2) {
            res = Math.max(res, dfs(i + 1, mod) + nums[i]);
        } else {
            res = Math.max(res, dfs(i + 1, nums[i] % 2) + nums[i] - x);
        }
        memo[i][mod] = res;
        return res;
    }
}
