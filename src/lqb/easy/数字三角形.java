package lqb.easy;

import java.util.Scanner;

public class 数字三角形 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //在此输入您的代码...
        int n = in.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        //[0] 代表左边
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 ) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j];
                } else if (j == n - 1) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + arr[i][j];
                }
            }
        }
        if (n % 2 == 1) {
            System.out.println(arr[n - 1][n / 2]);
        } else {
            System.out.println(Math.max(arr[n - 1][n / 2 - 1], arr[n - 1][n / 2 ]));
        }
    }
}
