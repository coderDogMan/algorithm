package week.week.year2023;

import java.util.Arrays;

public class 两个子序列的最大点积1458 {

//    int n;
//    int m;
//    int[] nums1;
//    int[] nums2;
//    int[][][] memo;
//    public int maxDotProduct(int[] nums1, int[] nums2) {
//        this.nums1 = nums1;
//        this.nums2 = nums2;
//        n = nums1.length;
//        m = nums2.length;
//        memo = new int[n][m][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
//            }
//        }
//        return dfs(0, 0, 0);
//    }
//
//    private int dfs(int i, int j, int isNum) {
//        if ((i >= n || j >= m) && isNum == 1) {
//            return 0;
//        }
//        if ((i == n - 1 || j == m - 1) && isNum == 0) {
//            return nums1[i] * nums2[j];
//        }
//        if (memo[i][j][isNum] != Integer.MIN_VALUE) return memo[i][j][isNum];
//        int res = dfs(i + 1, j + 1, isNum);
//        res = Math.max(res, dfs(i + 1, j + 1, 1) + nums1[i] * nums2[j]);
//        res = Math.max(res, dfs(i + 1, j, isNum));
//        res = Math.max(res, dfs(i, j + 1, isNum));
//        memo[i][j][isNum] = res;
//        return res;
//    }



    int n;
    int m;
    int[] nums1;
    int[] nums2;
    int[][] memo;
    int start;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        n = nums1.length;
        m = nums2.length;
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        start = nums1[0] * nums1[0];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n || j >= m) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
        int res = nums1[i] * nums2[j];
        res = Math.max(res, dfs(i + 1, j + 1));
        res = Math.max(res, dfs(i + 1, j + 1) + nums1[i] * nums2[j]);
        res = Math.max(res, dfs(i + 1, j));
        res = Math.max(res, dfs(i, j + 1));
        memo[i][j] = res;
        return res;
    }

}
class Test76 {
    public static void main(String[] args) {
        两个子序列的最大点积1458 test = new 两个子序列的最大点积1458();
        test.maxDotProduct(new int[]{-5,-1,-2}, new int[]{3,3,5,5});
//        test.maxDotProduct(new int[]{3,-2}, new int[]{2,-6,7});
    }

}
