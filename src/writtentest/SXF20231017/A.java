package writtentest.SXF20231017;

import java.util.Scanner;

public class A {
    static int nums1[];
    static int nums2[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        String[] s2 = in.nextLine().split(" ");
        int sum1 = 0, sum2 = 0;
        nums1 = new int[s1.length];
        nums2 = new int[s2.length];
        for (int i = 0; i < s1.length; i++) {
            nums1[i] = Integer.parseInt(s1[i]);
            sum1 += nums1[i];
        }
        for (int i = 0; i < s2.length; i++) {
            nums2[i] = Integer.parseInt(s2[i]);
            sum2 += nums2[i];
        }
        if (sum1 == sum2) {
            System.out.println("fail");
            return;
        }
        for (int i = 0; i < nums1.length; i++) {
            double target = (sum2 - sum1 + 2 * nums1[i]) * 1.0 / 2.0;
            int idx = find(target, nums2);
            if (nums2[idx] == target) {
                System.out.println(nums1[i] + " " + nums2[idx]);
                return;
            }
        }
        System.out.println("fail");

    }

    private static int find(double target, int[] nums2) {
        int l = 0;
        int r = nums2.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums2[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l == nums2.length) return l - 1;
        return l;
    }

}
