package week.week.year2023;

import java.util.Arrays;

public class 找出强数对的最大异或值I2932 {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int j = i;
            while (nums[j] <= nums[i] * 2) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
                j++;
            }
        }
        return ans;
    }
}
