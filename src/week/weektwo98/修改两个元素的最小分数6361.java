package week.weektwo98;

import java.util.Arrays;

// 1 4 5 7 8
public class 修改两个元素的最小分数6361 {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[left]) {
                nums[++left] = nums[i];
            }
        }
        if (left < 3) return 0;
        if (nums[1] - nums[0] > nums[left] - nums[left - 1]) {
            nums[0] = nums[1];
            if (nums[2] - nums[1] > nums[left] - nums[left - 1]) {
                return nums[left] - nums[2];
            } else {
                return nums[left - 1] - nums[1];
            }
        } else {
            nums[left] = nums[left - 1];
            if ((nums[1] - nums[0] > nums[left - 2] - nums[left - 1])) {
                return nums[left - 1] - - nums[1];
            } else {
                return nums[left - 2] - nums[0];
            }
        }
    }
}
