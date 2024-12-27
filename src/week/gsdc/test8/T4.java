package week.gsdc.test8;

import java.util.Arrays;
import java.util.Scanner;

public class T4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] dp = new long[20];
        long[] dpMax = new long[20];
        dp[1] = 1;
        for (int i = 2; i < 20; i++) {
            dp[i] = (dp[i - 1] * i);
        }
        Arrays.sort(dp);
        for (int i = 1; i < 20; i++)
            dpMax[i] = dp[i] * i + dp[i - 1];
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            int[] ans = new int[20];
            int max = 0;
            int idx = find(n, dpMax);
            while (n > 0) {
                max = Math.max(max, idx);
                ans[idx] = (int) (n / dp[idx]);
                n -= (ans[idx] * dp[idx]);
                idx--;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = max; i > 0; i--) {
                sb.append(ans[i]);
            }
            if (sb.length() == 0) {
                System.out.println("0");
                return;
            }
            System.out.println(sb.toString());
        }
    }
    // 大于等于
    private static int find(long n, long[] dpMax) {
        int l = 1;
        int r = dpMax.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (dpMax[mid] >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
