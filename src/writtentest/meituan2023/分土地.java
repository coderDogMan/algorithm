package writtentest.meituan2023;

import java.util.Scanner;

public class 分土地 {


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[][] map = new int[n][m];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                map[i][j] = in.nextInt();
//                sum += map[i][j];
//            }
//        }
//        int ans = Integer.MAX_VALUE;
//        int[] rows = new int[n];
//        int[] cols = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                rows[i] += map[i][j];
//            }
//        }
//
//
//        System.out.println(ans);
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[][] map = new long[n][m];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                sum += map[i][j];
            }
        }
        long rowSum = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) { // 上切下
            for (int j = 0; j < m; j++) {
                rowSum += map[i][j];
            }
            ans = Math.min(ans, Math.abs(sum - 2 * rowSum));
        }
        long colSum = 0;
        for (int j = 0; j < m; j++) { // 左切右
            for (int i = 0; i < n; i++) {
                colSum += map[i][j];
            }
            ans = Math.min(ans, Math.abs(sum - 2 * colSum));
        }

        System.out.println(ans);
    }
}
