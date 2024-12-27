package writtentest.pdd2023;

import java.util.Arrays;
import java.util.Scanner;

public class 飞机大战 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt();

        for (int i = 0; i < t; i++) {
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            Arrays.sort(nums);
            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == 1) {
                 ans++;
                } else {
                    break;
                }
            }
            ans = (n - ans) + (ans + 1) / 2;
            System.out.println(ans);
        }
    }
}
