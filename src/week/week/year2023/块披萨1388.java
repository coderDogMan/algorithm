package week.week.year2023;

public class 块披萨1388 {
    int[] slices;
    int n;
    public int maxSizeSlices(int[] slices) {
        this.slices = slices;
        n = slices.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            ans = Math.max(ans, dfs(i, vis));
        }
        return ans;
    }

    private int dfs(int i, boolean[] vis) {
        if (vis[i] == true) return 0;
        int res1 = slices[i];
        vis[i] = true;
        vis[(i - 1 + n) % n] = true;
        vis[(i + 1 + n) % n] = true;
        res1 += dfs((i - 2 + n) % n, vis);
        res1 += dfs((i + 2 + n) % n, vis);
        vis[(i - 1 + n) % n] = false;
        vis[(i + 1 + n) % n] = false;
        int res2 = dfs((i + 1) % n, vis);
        res2 += dfs((i - 1 + n) % n, vis);
        return Math.max(res1, res2);
    }
}
