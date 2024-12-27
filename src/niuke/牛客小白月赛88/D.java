package niuke.牛客小白月赛88;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int[] curPoint = new int[n];
            for (int j = 0; j < n; j++) {
                if (dp[j] != 0) {
                    curPoint[(j + n + x) % n] = 1;
                    curPoint[(j + n - x) % n] = 1;
                }
            }
            dp = curPoint;
        }

        if (dp[0] == 1) {
            System.out.println("yes");
        } else {
            System.out.printf("no");
        }


    }
}
