package writtentest.kdxf2023;

import java.util.Scanner;

public class 排列数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        int[] idxB = new int[n + 1];
        for (int i = 0; i < n; i++)
            nums1[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            nums2[i] = in.nextInt();
        for (int i = 0; i < n; i++) {
            idxB[nums2[i]] = i;
        }
        long ans = n * (n + 1L);
        int i = 0;
        while (i < n) {
            int idx = (int) i;
            int x = nums1[idx];
            int j = idxB[x];
            while (i < n && j < n && nums1[i] == nums2[j]) {
                i++;
                j++;
            }
            ans -= (i - idx) * (i - idx + 1) / 2;
        }
        System.out.println(ans);
    }
}
