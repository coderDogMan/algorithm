package writtentest.meituan2023;

import java.util.Scanner;

public class 最大数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }
        long ans = sum;
        for (int i = 1; i < n; i++) {
            long temp = sum;
            sum -= nums[i - 1];
            sum -= nums[i];
            ans = Math.max(ans, sum + nums[i - 1] * nums[i]);
            sum = temp;
        }
        System.out.println(ans);
    }
}
