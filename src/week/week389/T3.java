package week.week389;

import java.util.Arrays;

public class T3 {
    int[] cnt;
    int k;
    int[] memo;
    public int minimumDeletions(String word, int k) {
        cnt = new int[26];
        this.k = k;
        memo = new int[26];
        Arrays.fill(memo, -1);
        for (char c : word.toCharArray()) cnt[c - 'a']++;

        Arrays.sort(cnt);
        int ans = Integer.MAX_VALUE;
        int idx = 0;
        while (cnt[idx] == 0) idx++;
        ans = Math.min(ans, dfs(idx));
        return ans;
    }

    private int dfs(int idx) {
        if (idx >= 26) return 0;
        if (memo[idx] != -1) return memo[idx];
        int res = dfs(idx + 1) + cnt[idx];
        int res2 = 0;
        for (int i = idx + 1; i < 26; i++) {
            if (cnt[i] - k - cnt[idx] > 0) {
                res2 += (cnt[i] - k - cnt[idx]);
            }
        }
        return memo[idx] = Math.min(res, res2);
    }
}
