package writtentest.huawei2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 报数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int[] height = new int[200];
        for (int i = n - 1; i >= 0; i--) {
            height[nums[i] - 40]++;
            for (int j = 0; j < nums[i] - 40; j++) {
                ans[i] += height[j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(ans[i] + " ");
            } else {
                System.out.print(ans[i]);
            }
        }
    }
}
