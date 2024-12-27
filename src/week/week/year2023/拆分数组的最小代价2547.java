package week.week.year2023;

import java.util.Arrays;
import java.util.HashMap;

public class 拆分数组的最小代价2547 {
    int k;
    int[] nums;
    int[] memo;
    int[][] dp;
    public int minCost(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][n];
        byte[] bytes = new byte[n + 1];
        for (int i = 0; i < n; i++) {
            int one = 0;
            Arrays.fill(bytes, (byte) 0);
            for (int j = i; j < n; j++) {
                int x = nums[j];
                if (bytes[x] == 0) {
                    bytes[x] = 1;
                    one++;
                } else if (bytes[x] == 1){
                    bytes[x] = 2;
                    one--;
                }
                dp[i][j] = (j - i + 1) - one;
            }
        }


        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        int res = Integer.MAX_VALUE;
        for (int j = i; j < nums.length; j++) {
            res = Math.min(res, dp[i][j] + k + dfs(j + 1));
        }
        memo[i] = res;
        return res;
    }

    private int trimmed(int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = i;
        while (i <= j) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            i++;
        }
        int one = 0;
        for (Integer value : map.values()) {
            if (value == 1) one++;
        }
        dp[i][j] = j - start + 1 - one;
        return dp[i][j];
    }
}

class Test62 {
    public static void main(String[] args) {
        拆分数组的最小代价2547 test = new 拆分数组的最小代价2547();
        test.minCost(new int[]{1,2,1,2,1,3,3}, 2);
    }
}