package week.week.year2024firstQuarter;

import java.util.HashMap;

public class 最大好子数组和3026 {
    long INF = Long.MAX_VALUE / 2;
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        long[] sum = new long[n + 1];
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k)) {
                ans = Math.max(ans, sum[i + 1] - map.getOrDefault(nums[i] - k, INF));
            }
            if (map.containsKey(nums[i] + k)) {
                ans = Math.max(ans, sum[i + 1] - map.getOrDefault(nums[i] + k, INF));
            }
            map.merge(nums[i], sum[i], Math::min);
        }
        return ans > Long.MIN_VALUE / 4 ? ans : 0;
    }
}

class Test4 {
    public static void main(String[] args) {
        最大好子数组和3026 test = new 最大好子数组和3026();
//        test.maximumSubarraySum(new int[]{-1,-2,-3,-4}, 2);
//        test.maximumSubarraySum(new int[]{1,5}, 2);
        test.maximumSubarraySum(new int[]{1,2,3,4,5,6}, 1);
    }
}