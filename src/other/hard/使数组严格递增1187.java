package other.hard;

import java.util.Arrays;

public class 使数组严格递增1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr2);
        int[][] dp = new int[n + 1][Math.min(n, m) + 1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        dp[0][0] = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, m); j++) {
                if (arr1[i - 1] > dp[i - 1][j]) {
                    dp[i][j] = arr1[i - 1];
                }
                if (j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE / 2) {
                    int idx = findLow(arr2, dp[i - 1][j - 1]);
                    if (idx != m) dp[i][j] = Math.min(dp[i][j], arr2[idx]);
                }
                if (i == n && dp[i][j] != Integer.MAX_VALUE / 2)
                    return j;
            }
        }
        return -1;
    }

    //找大于target的数
    private int findLow(int[] arr2, int target) {
        int left = 0;
        int right = arr2.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr2[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

class Test9 {
    public static void main(String[] args) {
        使数组严格递增1187 test = new 使数组严格递增1187();
//        test.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,3,2,4});
//        test.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,6,3,3});
        test.makeArrayIncreasing(new int[]{0,11,6,1,4,3}, new int[]{5,4,11,10,1,0});
    }
}