package niuke.牛客小白月赛89;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        if (n == 1 || m == 1) {
            System.out.println("No");
            return;
        }
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if (m - diff >= 2) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");



    }
}
