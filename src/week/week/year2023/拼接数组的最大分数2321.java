package week.week.year2023;

public class 拼接数组的最大分数2321 {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = Math.min(0, nums1[0] - nums2[0]);
        dp[0][1] = Math.min(0, nums2[0] - nums1[0]);
        int min1 = dp[0][0];
        int min2 = dp[0][0];
        int sum1 = nums1[0];
        int sum2 = nums2[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(0, dp[i - 1][0] + (nums1[i] - nums2[i]));
            dp[i][1] = Math.min(0, dp[i - 1][1] + (nums2[i] - nums1[i]));
            min1 = Math.min(min1, dp[i][0]);
            min2 = Math.min(min2, dp[i][1]);
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        return Math.max(sum1 - min1, sum2 - min2);
    }

//

//    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int sum1 = 0, sum2 = 0;
//        int[] diff = new int[n];
//        for (int i = 0; i < n; i++) {
//            sum1 += nums1[i];
//            sum2 += nums2[i];
//            diff[i] = nums1[i] - nums2[i];
//        }
//        int up1 = 0;
//        int curUp1 = 0;
//        int up2 = 0;
//        int curUp2 = 0;
//        for (int i = 1; i < n; i++) {
//            if (curUp1 + diff[i] < 0) {
//                curUp1 += diff[i];
//                up1 = Math.min(up1, curUp1);
//            } else {
//                curUp1 = 0;
//            }
//
//            if (curUp2 + diff[i] > 0) {
//                curUp2 += diff[i];
//                up2 = Math.max(up2, curUp2);
//            } else {
//                curUp2 = 0;
//            }
//        }
//        return Math.max(sum1 - up1, sum2 + up2);
////-40 40
//    }
}

class Test39 {
    public static void main(String[] args) {
        拼接数组的最大分数2321 test = new 拼接数组的最大分数2321();
        test.maximumsSplicedArray(new int[]{60,60,60}, new int[]{10,90,10});
    }
}