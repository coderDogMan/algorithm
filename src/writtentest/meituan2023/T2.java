package writtentest.meituan2023;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            ans += nums[i] - nums[i - 1];
        }
        System.out.println(ans);
    }
}
