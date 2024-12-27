package writtentest.huawei2023;


import java.util.Scanner;

public class D路通信 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        //dp[i][j] s1第i个 和 s2第j个最长公共子串长度
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int ans = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
