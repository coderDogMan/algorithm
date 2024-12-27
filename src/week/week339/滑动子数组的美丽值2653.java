package week.week339;

import java.util.HashMap;

public class 滑动子数组的美丽值2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] map = new int[101];
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k - 1; i++) {
            map[nums[i] + 50]++;
        }
        int idx = 0;
        for (int i = k - 1; i < n; i++) {
            map[nums[i] + 50]++;
            int num = 0;
            int j = 0;
            for (; j < map.length; j++) {
                num += map[j];
                if (num >= x) break;
            }
            ans[idx++] = j - 50 > 0 ? 0 : j - 50;
            map[nums[i - k + 1] + 50]--;
        }
        return ans;
    }
}
class Test10 {
    public static void main(String[] args) {
        滑动子数组的美丽值2653 test = new 滑动子数组的美丽值2653();
        test.getSubarrayBeauty(new int[]{-3,1,2,-3,0,-3}, 2,  1);
    }
}
