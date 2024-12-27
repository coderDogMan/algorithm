package week.weektwo125;

import java.util.Arrays;
import java.util.LinkedList;

public class T4 {

    LinkedList<Integer>[] g;
    long k;
    int[] nums;
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        g = new LinkedList[n];
        this.k = k;
        this.nums = nums;
        Arrays.setAll(g, e -> new LinkedList());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        long[] res = dfs(-1, 0);
        return res[0];
    }

    private long[] dfs(int fa, int cur) {
        long r0 = 0, r1 = Integer.MIN_VALUE;
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            long[] res = dfs(cur, son);
            r0 = Math.max(res[0] + nums[son], res[1] + nums[son] % k);
            r1 = Math.max(res[0] +  nums[son] % k, res[1] + nums[son]);
        }

        return new long[] {Math.max(r0 + nums[cur], r1 + nums[cur] % k), Math.max(r1 + nums[cur], r0 + nums[cur] % k)};
    }

}

class Test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.maximumValueSum(new int[]{1,2,1}, 3, new int[][]{{0, 1}, {1, 0}});
    }
}
