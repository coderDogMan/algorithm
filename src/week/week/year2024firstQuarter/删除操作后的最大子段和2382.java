package week.week.year2024firstQuarter;

public class 删除操作后的最大子段和2382 {

    int[] fa;
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) fa[i] = i;
        long[] sum = new long[n + 1];

        long[] ans = new long[n];
        for (int i = n - 1; i >= 0; i++) {
            int x = removeQueries[i];
            int to = find(x + 1);
            fa[x] = to;
            sum[to] += sum[x] + nums[i];
            ans[i] = sum[to];
        }
        return ans;
    }

    private int find(int x) {
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
