package week.week.year2023;

import java.util.Arrays;

public class 三次操作后最大值与最小值的最小差1509 {
    public int minDifference(int[] nums) {
        if (nums.length <= 3) return 0;
        Arrays.sort(nums);
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, nums[r - 3] - nums[0]);
        ans = Math.min(ans, nums[r - 2] - nums[1]);
        ans = Math.min(ans, nums[r - 1] - nums[2]);
        ans = Math.min(ans, nums[r] - nums[3]);
        return ans;
    }
}
