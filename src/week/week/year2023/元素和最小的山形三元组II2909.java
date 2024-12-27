package week.week.year2023;

public class 元素和最小的山形三元组II2909 {


    public int minimumSum(int[] nums) {
        int n = nums.length;
        int left = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) right[i] = Math.min(nums[i], right[i + 1]);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (left < nums[i] && right[i + 1] < nums[i]) ans = Math.min(ans, left + nums[i] + right[i + 1]);
            left = Math.min(left, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
