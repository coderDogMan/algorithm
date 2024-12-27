//package week.week.year2024firstQuarter;
//
//import java.util.Arrays;
//
//public class 拆分数组的最小代价2547 {
//
//    int INF = Integer.MIN_VALUE/ 2;
//    public int minCost(int[] nums, int k) {
//        int n = nums.length;
//        int[][] f = new int[n + 1][n + 1];
//        for (int i = 0; i <= n; i++) Arrays.fill(f[i], INF);
//        for (int i = 1; i <= n; i++) {
//            f[i][1] = trimmed
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= Math.min(i, n); j++) {
//                for (int l = 1; i - l >= j - 1; l++)
//                    f[i][j] = Math.min(f[i][j], f[i - l][j - 1] + k + trimmed(l, i));
//            }
//        }
//
//
//    }
//}
