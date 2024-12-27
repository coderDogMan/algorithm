package codeFun2000.塔子月赛第一场;

import java.util.Arrays;
import java.util.Scanner;

public class 苦逼打工塔 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = in.nextInt();
            nums2[i] = nums1[i];
        }
        Arrays.sort(nums2);
        int idx = 0;
        while (nums2[idx] == -1) idx++;
        int mid = nums2[(idx + n) / 2];
        int l = -1;
        int i = 0;
        while (nums1[i] == -1) i++;
        int start = i;

        for (; i < n; i++) {
            //遇到
            if (l == -1 && nums1[i] == -1) {
                l = i;
            } else if (l != -1 && nums1[i] == -1) {
                continue;
            } else if (l != -1 && nums1[i] != -1 ) {
                nums1[i] = getNum(mid, k, nums1[i]);
                if (i - l > 3) {
                    for (int j = l; j < i; j++) nums1[j] = -1;
                } else {
                    for (int j = l; j < i; j++) nums1[j] = nums1[l - 1];
                }
                l = -1;
            } else {
                nums1[i] = getNum(mid, k, nums1[i]);
            }
        }
        if (l != -1) {
            if (n - l > 3) {
                for (int j = l; j < n; j++) nums1[j] = -1;
            } else {
                for (int j = l; j < n; j++) nums1[j] = nums1[l - 1];
            }
        }
        for (i = start; i < n; i++)
            System.out.print(nums1[i] + " ");
    }

    private static int getNum(int mid, int k, int val) {
        if (Math.abs(mid - val) <= k) {
            return 1;
        } else if (val < mid) {
            return 0;
        } else {
            return 2;
        }
    }
}
