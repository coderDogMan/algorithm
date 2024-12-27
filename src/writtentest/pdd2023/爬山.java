package writtentest.pdd2023;

import java.util.Scanner;

public class 爬山 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            int[] nums = new int[size];
            //第i阶的方案
            long[] dp = new long[size];
            int max = 0;
            for (int j = 0; j < size; j++) {
                nums[j] = in.nextInt();
                max = Math.max(max, nums[j]);
            }
            if (max > p) {
                System.out.println(0);
                return;
            }
            long sum = nums[0];
            for (int j = 0; j < k && sum <= p; j++) {
                dp[j] = 1;
                sum += nums[j + 1];
            }
            for (int j = 1; j < size; j++) {
                int temp = k;
                int t = j;
                long val = nums[j];
                for (t = j; t > 0 && val <= p && temp > 0; t--, temp--) {
                    val = (val + nums[t - 1]) % 1000000007;
                }
//                val %= 1000000007;
                // t - j
                for (; t < j; t++) {
                    dp[j] = (dp[j] +  dp[t]) % 1000000007;
                }
//                dp[j] %= 1000000007;
            }
            System.out.println(dp[size - 1]);
        }
    }
}
