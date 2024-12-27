package writtentest.bateDance;

import java.util.Arrays;
import java.util.Scanner;

public class 塔子哥的优雅数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        if (nums[0] == nums[n - 1]) {
            System.out.println(1);
            return;
        }
        long ans = Long.MAX_VALUE;
        int l = 1;
        int r = n - 1;
        //去头
        int mid = (l + r) / 2;
        long op = 0;
        for (int i = 1; i < n; i++) {
            op += Math.abs(nums[i] - nums[mid]);
        }
        ans = Math.min(ans, op);
        if ((l + r) % 2 == 0) {
            int mid2 = (l + r + 1) / 2;
            op = 0;
            for (int i = 1; i < n; i++) {
                op += Math.abs(nums[i] - nums[mid2]);
            }
            ans = Math.min(ans, op);
        }
        // 去尾
        l = 0;
        r = n - 2;
        mid = (l + r) / 2;
        op = 0;
        for (int i = 0; i < n - 1; i++) {
            op += Math.abs(nums[i] - nums[mid]);
        }
        ans = Math.min(ans, op);
        if ((l + r) % 2 == 0) {
            int mid2 = (l + r + 1) / 2;
            op = 0;
            for (int i = 0; i < n - 1; i++) {
                op += Math.abs(nums[i] - nums[mid2]);
            }
            ans = Math.min(ans, op);
        }
        System.out.println(ans);
    }
}
