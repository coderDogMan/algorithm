package week.week390;

public class T2 {

    public int minOperations(int k) {
        int ans = k;
        for (int i = 1; i <= k; i++) {
            ans = Math.min(ans, (k + i - 1) / i + i);
        }
        return ans;
    }
}
