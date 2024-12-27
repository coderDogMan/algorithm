package week.week.year2023;

import java.util.HashMap;

public class 最多K个重复元素的最长子数组2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            map.merge(key, 1, Integer::sum);
            while (map.get(key) > k) {
                map.merge(nums[l++],-1, Integer::sum);
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }

}
