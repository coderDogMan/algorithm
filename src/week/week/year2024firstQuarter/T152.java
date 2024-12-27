package week.week.year2024firstQuarter;

public class T152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][2];
        f[0][0] = nums[0];
        f[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) continue;
            f[i][0] = Math.max(f[i - 1][0] * nums[i], Math.max(f[i - 1][1] * nums[i], nums[i]));
            f[i][1] = Math.min(f[i - 1][0] * nums[i], Math.max(f[i - 1][1] * nums[i], nums[i]));
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f[i][0]);
        }
        return ans;
    }
}
