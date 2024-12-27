package writtentest.SXF20231017;

import java.util.ArrayList;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        if (n + m - 1 > k) {
            System.out.println(0);
            return;
        }
        int[][][] dp = new int[n][m][k];
        int[][] points = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int q = k - 1; q >= 0; q++) {
                    for (int[] point : points) {
                        int x = i + point[0];
                        int y = i + point[1];
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            if (q - 1 >= 0)
                                dp[i][j][q] += dp[x][y][q - 1] + 1;
                            if (k - 2 >= 0)
                                dp[i][j][q] += dp[i][j][q - 2] + 4;
                        }
                    }
                }
            }
        }
        System.out.println(dp[n - 1][m - 1][k - 1]);

    }
}
