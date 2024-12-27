package other.mid;

import java.util.HashMap;

public class 两个线段获得的最多奖品2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] perSum = new int[n + 1];
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            while (prizePositions[r] - prizePositions[l] > k) l++;
            ans = Math.max(ans, r - l + 1 + perSum[l]);
            perSum[r + 1] = Math.max(perSum[r], r - l + 1);
        }
        return ans;
    }
}
