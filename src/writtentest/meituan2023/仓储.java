package writtentest.meituan2023;

import writtentest.huawei2023.分配资源ID;

import java.util.Scanner;

public class 仓储 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int start = in.nextInt() - 1;
        int end = in.nextInt() - 1;
        long ans1 = 0;
        for (int i = start; i < end + n; i++) {
            if (i % n == end) break;
            ans1 += nums[i % n];
        }
        long ans2 = 0;
        for (int i = start + n; i >= start; i--) {
            if (i % n == end) break;
            ans2 += nums[(i - 1) % n];
        }

        System.out.println(Math.min(ans1, ans2));
    }
}
