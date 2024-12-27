package week.week.year2023;

public class 最长递增子序列II2407 {

    int[] nums;
    int k;
    int[][] memo;
    public int lengthOfLIS(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int n = nums.length;
        memo = new int[n][100001];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i + 1, nums[i]) + 1);
        }
        return ans;

    }

    private int dfs(int i, int last) {
        if (i == nums.length) return 0;
        if (memo[i][last] != 0) return memo[i][last];
        int cur = nums[i];
        int res = dfs(i + 1, last);
        if (cur > last && cur - last <= k) {
            res = Math.max(dfs(i + 1, cur) + 1, res);
        }
        memo[i][last] = res;
        return res;
    }


}
