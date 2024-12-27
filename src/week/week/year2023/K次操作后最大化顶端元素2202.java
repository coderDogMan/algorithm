package week.week.year2023;

public class K次操作后最大化顶端元素2202 {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }
        if (k == 0) {
            return nums[0];
        } else if (k == 1) {
            return nums[1];
        } else {
            int max = nums[0];
            int i = 0;
            for (; i < nums.length && k > 1; i++, k--) {
                max = Math.max(max, nums[i]);
            }
            if (k == 1 && i + 1 < nums.length) {
                max = Math.max(max, nums[i + 1]);
            }
            return max;
        }

    }
}
