package week.week.year2023;

public class 环形子数组的最大和918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int curMax = 0;
        int curMin = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (curMax + nums[i] > 0) {
                curMax += nums[i];
                max = Math.max(max, curMax);
            } else {
                curMax = 0;
                max = Math.max(max, nums[i]);
            }

            if (curMin + nums[i] < 0) {
                curMin += nums[i];
                min = Math.min(min, curMin);
            } else {
                curMin = 0;
                min = Math.min(min, nums[i]);
            }
        }

        if (sum == min) {
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }
}

class Test28 {
    public static void main(String[] args) {
        环形子数组的最大和918 test = new 环形子数组的最大和918();
        test.maxSubarraySumCircular(new int[]{5,-3,5});
//        test.maxSubarraySumCircular(new int[]{1,-2,3,-2});
    }
}
