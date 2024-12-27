package writtentest.si399;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + ( i - 2 >= 0 ? dp[i - 2] : 0);
        }
        System.out.println(dp[n]);
    }
}
