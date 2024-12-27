package week.week401;

import java.util.Arrays;

/**
 * @Author: min
 * @Date:
 */
public class T4 {

    int n;
    public int maxTotalReward(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        int size = nums[n - 1];
        int[] dp = new int[size];
        for (int i = 0; i < n; i++) {
            for (int j = size - 1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return nums[n - 1] + dp[size - 1];
    }
}
class Test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        System.out.println(t4.maxTotalReward(new int[]{1, 1, 3, 3}));
    }
}

