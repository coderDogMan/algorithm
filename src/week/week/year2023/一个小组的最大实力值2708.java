package week.week.year2023;

import java.util.Arrays;

public class 一个小组的最大实力值2708 {

    int[] nums;
    long[][] memo;
    public long maxStrength(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        // 0 +  1 -
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        memo[0][0] = nums[1];
        memo[0][1] = nums[1];
        return dfs(n - 1, 0);
    }

    private long dfs(int i, int j) {
        if (i == 0) {
            return memo[i][j];
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        memo[i][0] = Math.max(Math.max(nums[i], dfs(i - 1, 0)), Math.max(dfs(i - 1, 0) * nums[i], dfs(i - 1, 1) * nums[i]));

        memo[i][1] = Math.min(Math.min(nums[i], dfs(i - 1, 1)), Math.min(dfs(i - 1, 0) * nums[i], dfs(i - 1, 1) * nums[i]));


        return memo[i][j];
    }
}

class Test44 {
    public static void main(String[] args) {
        一个小组的最大实力值2708 test = new 一个小组的最大实力值2708();
        test.maxStrength(new int[]{-1,-7,-5,7,7,0,9,0,-5,-6});
    }
}