package week.week393;

import java.util.HashMap;

public class T4 {

    int[] nums;
    int[] andValues;
    int n, m, INF = Integer.MAX_VALUE / 2;
    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        n = nums.length;
        m = andValues.length;
        HashMap<Long, Integer> map = new HashMap<>();
        int ans = dfs(0, 0, -1, map);
        return ans >= INF ? -1 : ans;
    }

    private int dfs(int i, int j, int and, HashMap<Long, Integer> memo) {
        if (n - i < m - j) return INF;
        if (i == n) {
            if (j == m) return 0;
            return INF;
        }
        if (j == andValues.length) return INF;

        long mask = (long) i << 36 | (long) j << 32 | (and & nums[i]);
        if (memo.containsKey(mask)) return memo.get(mask);

        int res = dfs(i + 1, j, and & nums[i], memo); // 不划分
        if ((and & nums[i]) == andValues[j]) { // 划分，nums[i] 是这一段的最后一个数
            res = Math.min(res, dfs(i + 1, j + 1, -1, memo) + nums[i]);
        }

        memo.put(mask, res);
        return res;
    }
}
