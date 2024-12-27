package writtentest.meituan20230902;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                System.out.println("No");
                return;
            }
            B[i] = nums[i] - nums[i - 1];
        }
        for (int i = 2; i < n; i++) {
            if (B[i] >= B[i - 1]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
