package writtentest.rouyao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 流水线 {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        double[][] map = new double[n][m];
        double[][] dp = new double[n][m];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Double.parseDouble(s[j]);
            }
        }
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + map[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        System.out.printf("%.6f", dp[n - 1][m - 1]);
    }
}
