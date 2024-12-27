package other.hard;

import other.mid.每日温度739;

public class 寻找两个正序数组的中位数4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] temp =  nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int leftNum = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            int i = (left + right + 1) / 2;
            int j = leftNum - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = leftNum - i;
        int upLeft = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int upRight = i == m ? Integer.MAX_VALUE : nums1[i];
        int downLeft = j == 0 ? Integer.MIN_VALUE : nums1[j - 1];
        int downRight = j == n ? Integer.MAX_VALUE : nums1[j];

        if ((m + n) % 2 == 1) {
            return (double)Math.max(upLeft, downLeft);
        }
        return (Math.max(upLeft, downLeft) + Math.min(upRight, downRight)) * 0.5;
    }
}

