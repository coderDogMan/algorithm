package week.gsdc.test1;

import java.util.Scanner;

public class TB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        if (m == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[m + 1];
        dp[1] = 1;
        for (int i = 2; i <= m; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10086;
        }
        int ans = 0;
        for (int i = 1; i < m; i++) {
            if (m % i == 0) {
                ans = (ans + dp[i]) % 10086;
            }
        }
        System.out.println(ans);
    }
}
