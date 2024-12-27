package week.week339;

import java.util.Arrays;

public class 最小化数对的最大差值2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = (int) 1e9;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, nums, p)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    // 可以找到 p 对差值 <= val 的数吗
    private boolean check(int val, int[] nums, int p) {
        int n = nums.length;
        int num = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= val) {
                num++;
                i++;
            }
            if (num >= p) return true;
        }
        return false;
    }
}
