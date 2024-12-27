package week.week.year2024firstQuarter;

import java.util.Arrays;

public class T2321 {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int[] f = new int[n];
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        f[0] = diff[0];
        int max1 = diff[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + diff[i], diff[i]);
            max1 = Math.max(max1, f[i]);
        }
        f[0] = diff[0];
        int min = diff[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.min(f[i - 1] + diff[i], diff[i]);
            min = Math.min(min, f[i]);
        }

        return Math.max(sum2 + max1, sum1 - min);
    }
}
