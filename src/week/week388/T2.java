package week.week388;

import java.util.Arrays;

public class T2 {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long ans = 0;
        int start = 0;
        for (int i = n - 1; i >= 0 && k > 0; i--, k--) {
            ans += happiness[i];
            ans -= Math.max(0, happiness[i] - start);
            start++;
        }
        return ans;
    }
}
