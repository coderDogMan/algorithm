package other.easy;

import other.mid.跳跃游戏II45;

import java.util.Arrays;

public class K次取反后最大化的数组和1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i;
        int res = 0;
        for (i = 0; i < nums.length - 1 && k > 0; i++) {
            if(Math.abs(nums[i]) >= Math.abs(nums[i + 1]) && nums[i] < 0) {
                nums[i] = -nums[i];
                res += nums[i];
                k--;
            } else {
                break;
            }
        }
        if (k % 2 == 1) nums[i] = -nums[i];
        for (; i < nums.length; i++)
            res += nums[i];
        return res;
    }
}
