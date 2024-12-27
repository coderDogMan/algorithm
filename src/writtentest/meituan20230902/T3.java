package writtentest.meituan20230902;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        long ans = 0;
        long temp = nums[0];
        while (nums[0] < max) {
            ans++;
            nums[0] *= 2;
        }
        long ans2 = 0;
        nums[0] = temp;
        for (int i = 1; i < n; i++) {
            while (nums[0] < nums[i]) {
                ans2++;
                nums[i] /= 2;
            }
        }
        System.out.println(Math.min(ans, ans2));
    }

//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        long[] nums = new long[n];
//        long max = 0;
//        long second = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//            if (nums[i] > max) {
//                second = max;
//                max = nums[i];
//            }
//        }
//        int ans = 0;
//        while (nums[0] < max) {
//            ans++;
//            nums[0] *= 2;
//        }
//        if (nums[0] == second) {
//            int ans2 = 0;
//            while (nums[0] < max) {
//                ans2++;
//                max /= 2;
//            }
//            System.out.println(Math.min(ans, ans2));
//            return;
//        }
//        System.out.println(ans);
//
//
//    }
}
