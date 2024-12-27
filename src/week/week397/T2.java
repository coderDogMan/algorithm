package week.week397;

import java.util.Arrays;

/**
 * @Author: min
 * @Date:
 */
public class T2 {

    int k;
    int n;
    int[] energy;
    int[] memo;
    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        this.k = k;
        this.energy = energy;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    private int dfs(int i) {
        if (i >= n) return 0;
        if (memo[i] != Integer.MIN_VALUE) return memo[i];
        int res = dfs(i + k) + energy[i];
        return memo[i] = res;
    }

}
