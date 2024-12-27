package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 销售利润最大化2830 {
    LinkedList<int[]>[] g;
    int[] memo;
    int n;
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        this.n = n;
        g = new LinkedList[n];
        memo = new int[n];
        Arrays.fill(memo, -1);
        Arrays.setAll(g, e -> new LinkedList<>());
        for (List<Integer> o : offers) g[o.get(0)].add(new int[]{o.get(1), o.get(2)});
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 0;
        if (memo[i] != -1) return memo[i];
        int res = dfs(i + 1);
        for (int[] v : g[i]) res = Math.max(res, dfs(v[0] + 1) + v[1]);
        return memo[i] = res;
    }
}
