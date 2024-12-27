package writtentest.mt2023;

import java.util.Arrays;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            int max = -1, min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= Math.max(0, i - m); j--) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                int cost = (i - j) * ((max + min) / 2) + s;
                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }
        System.out.println(dp[n]);

    }
}
