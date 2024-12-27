package writtentest.bateDance;

import java.util.Scanner;

public class 字符串的美好值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1] + i + 1;
            }
        }
        long ans = 0;
        for (long num : dp) {
            ans += num;
        }
        System.out.println(ans);

    }
}
