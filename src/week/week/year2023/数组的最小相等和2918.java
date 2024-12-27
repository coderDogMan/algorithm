package week.week.year2023;

public class 数组的最小相等和2918 {
    public long minSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        long sum1 = 0;
        long sum2 = 0;
        int zero1 = 0;
        int zero2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            if (nums1[i] == 0) zero1++;
        }
        for (int i = 0; i < m; i++) {
            sum2 += nums2[i];
            if (nums2[i] == 0) zero2++;
        }
        if (zero1 == 0 && sum2 + zero2 > sum1) return -1;
        if (zero2 == 0 && sum1 + zero1 > sum2) return -1;
        return Math.max(sum1 + zero1, sum2 + zero2);
    }
}
class Test92 {
    public static void main(String[] args) {
        数组的最小相等和2918 test = new 数组的最小相等和2918();
        test.minSum(new int[]{0,17,20,17,5,0,14,19,7,8,16,18,6}, new int[]{21,1,27,19,2,2,24,21,16,1,13,27,8,5,3,11,13,7,29,7});
    }
}
