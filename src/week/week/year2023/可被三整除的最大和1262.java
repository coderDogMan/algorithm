package week.week.year2023;

import java.util.Arrays;

public class 可被三整除的最大和1262 {
    int[] nums;
    int[][] dp;
    public int maxSumDivThree(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][3];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        dfs(n - 1, 0);

        return dp[n - 1][0];
    }

    private int dfs(int i, int j) {
        if (i < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = Math.max(dfs(i - 1, j), dfs(i - 1, (j + nums[i]) % nums[i]) + nums[i]);
        return dp[i][j];
    }


}


class Test24 {
    public static void main(String[] args) {
        可被三整除的最大和1262 test = new 可被三整除的最大和1262();
        test.maxSumDivThree(new int[]{3,6,5,1,8});
    }
}