package writtentest.pdd2023;

import java.util.Scanner;

public class 塔子哥的好数组对 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            long[][] dp = new long[n][2];
            int[][] change = new int[n][2];
            change[0][1] = 1;
            for (int i = 0; i < n; i++) A[i] = in.nextInt();
            for (int i = 0; i < n; i++) B[i] = in.nextInt();
            for (int i = 1; i < n; i++) {
                if (dp[i - 1][1] + Math.abs(A[i] - B[i - 1]) + Math.abs(B[i] - A[i - 1]) > dp[i - 1][0] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1])) {
                    dp[i][0] = dp[i - 1][1] + Math.abs(A[i] - B[i - 1]) + Math.abs(B[i] - A[i - 1]);
                    change[i][0] = change[i - 1][1];
                } else if (dp[i - 1][1] + Math.abs(A[i] - B[i - 1]) + Math.abs(B[i] - A[i - 1]) < dp[i - 1][0] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1])) {
                    dp[i][0] = dp[i - 1][0] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1]);
                    change[i][0] = change[i - 1][0];
                } else {
                    dp[i][0] = dp[i - 1][0] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1]);
                    change[i][0] = Math.min(change[i - 1][0], change[i - 1][1]);
                }

                if (dp[i - 1][1] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1]) > dp[i - 1][0] + Math.abs(A[i] - B[i - 1]) + Math.abs(B[i] - A[i - 1])) {
                    dp[i][1] = dp[i - 1][1] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1]);
                    change[i][1] = change[i - 1][1] + 1;
                } else if (dp[i - 1][1] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1]) < dp[i - 1][0] + Math.abs(A[i] - B[i - 1]) + Math.abs(B[i] - A[i - 1])) {
                    dp[i][1] = dp[i - 1][0] + Math.abs(A[i] - B[i - 1]) + Math.abs(B[i] - A[i - 1]);
                    change[i][1] = change[i - 1][0] + 1;
                } else {
                    dp[i][1] = dp[i - 1][1] + Math.abs(A[i] - A[i - 1]) + Math.abs(B[i] - B[i - 1]);
                    change[i][1] = Math.min(change[i - 1][0] + 1, change[i - 1][1] + 1);
                }
            }
            if (dp[n - 1][1] > dp[n - 1][0]) {
                System.out.println(change[n - 1][1]);
            } else if (dp[n - 1][1] < dp[n - 1][0]){
                System.out.println(change[n - 1][0]);
            } else {
                System.out.println(Math.min(change[n - 1][0], change[n - 1][1]));
            }


        }
    }


}
