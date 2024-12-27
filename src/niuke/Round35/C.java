package niuke.Round35;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        Arrays.sort(nums);
        double max = 0;
        int l = 0;
        for (int i = 1; i < n; i++) {
            while (nums[i] - nums[l] > k) {
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        System.out.println(max / n);

    }
}
