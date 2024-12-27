package niuke.中国石油大学北京第三届骏码杯程序设计竞赛;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int k = in.nextInt();
        while (k-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            double[][] arr = new double[n][3];
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                arr[i][1] = b;
                arr[i][2] = c;
                arr[i][0] = a * (1 - 0.004 * b) - (50 * c > a * 0.3 ? a * 0.3 : 50 * c);
            }
            Arrays.sort(arr, (a, b) -> (int) (a[0] - b[0]));
            double ans = arr[n - 1][0];
            for (int i = n - 2; i >= 0; i--) {
                ans = ans + arr[i][0] * (1 - 0.004 * arr[i + 1][1]);
                arr[i][1] += arr[i + 1][1];
            }
            System.out.println((int) ans);
        }

    }
}
