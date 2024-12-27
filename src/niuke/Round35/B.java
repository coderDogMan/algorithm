package niuke.Round35;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() * 2;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i += 2) {
            if (nums[i] != nums[i + 1]) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < n; i += 2) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < n; i += 2) {
            System.out.print(nums[i] + " ");
        }

    }
}
