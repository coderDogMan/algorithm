package array.easy;

import java.util.Arrays;

public class Merge88 {

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }


    //双指针法，从后往前排
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int total = m + n - 1;
        int cur;
        while (p1 >= 0 || p1 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            nums1[total] = cur;
        }
        return;
    }

    //直观
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (n == 0) {
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);
//    }

}
