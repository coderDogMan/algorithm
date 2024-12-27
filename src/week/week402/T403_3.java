package week.week402;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @Author: min
 * @Date:
 */
public class T403_3 {

    public long maximumTotalCost(int[] nums) {
        long[] memo = new long[nums.length];
        Arrays.fill(memo, Long.MIN_VALUE / 2);
        return dfs(0, nums, memo);
    }

    private long dfs(int i, int[] nums, long[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] != Long.MIN_VALUE / 2) return memo[i];
        long res = nums[i] + dfs(i + 1, nums, memo);
        if (i + 1 < nums.length)
            res = Math.max(res, nums[i] - nums[i + 1] + dfs(i + 2, nums, memo));
        return memo[i] = res;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 1000; i += 100) {
            
        }

    }

}



