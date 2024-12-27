package week.week.year2024secondQuarter;

import java.util.Arrays;

/**
 * @Author: min
 * @Date:
 */
public class T2009 {

    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) nums[m++] = nums[i];
        }

        int ans = 0;
        int l = 0;
        for (int i = 0; i < m; i++) {
            while (nums[l] < nums[i] - n + 1) {
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;

    }
}
