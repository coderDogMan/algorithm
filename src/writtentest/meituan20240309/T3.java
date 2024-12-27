package writtentest.meituan20240309;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String s = in.next();
            for (int j = 1; j <= n; j++) {
                sum[i][j] = (s.charAt(j - 1) - '0') + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        System.out.println(0);
        for (int k = 1; k < n; k++) {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i + k > n || j + k > n) continue;

                    int one = sum[i + k][j + k] - sum[i + k][j - 1] - sum[i - 1][j + k] + sum[i - 1][j - 1] ;
                    if ((k + 1) * (k + 1) - one == one) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

}
