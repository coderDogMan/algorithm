package week.week.year2023;

import java.util.Arrays;
import java.util.LinkedList;

public class 在树上执行操作以后得到的最大分数2925 {

    LinkedList<Integer>[] g;
    int[] values;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = edges.length + 1;
        g = new LinkedList[n];
        long sum = 0;
        for (int i = 0; i < n; i++) sum += values[i];
        this.values = values;
        Arrays.setAll(g, e -> new LinkedList());
        g[0].add(-1);
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        return sum - dfs(-1, 0);

    }

    private long dfs(int fa, int cur) {
        if (g[cur].size() == 1) return values[cur];
        long res1 = values[cur];
        long res2 = 0;
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            res2 += dfs(cur, son);
        }
        return Math.min(res1, res2);
    }


}
class Test91 {
    public static void main(String[] args) {
        在树上执行操作以后得到的最大分数2925 test = new 在树上执行操作以后得到的最大分数2925();
        test.maximumScoreAfterOperations(new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}}, new int[]{20,10,9,7,4,3,5});
    }
}
