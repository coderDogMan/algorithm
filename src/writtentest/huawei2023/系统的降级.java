package writtentest.huawei2023;

import java.util.Arrays;
import java.util.Scanner;

public class 系统的降级 {
    static long[] sum;
    static long cnt;
    static long[] nums;
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nums = Arrays.stream(in.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        n = nums.length;
        sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        cnt = Long.parseLong(in.nextLine());
        int l = 0;
        int r = 1000000000;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(r == 1000000000 ? -1 : r);
    }
    // 找 val 是否小于cnt
    private static boolean check(int val) {
        long ans = 0;
        //大于val的idx
        for (int i = 0; i < n; i++) {
            ans += nums[i] > val ? val : nums[i];
        }
        return ans <= cnt;
    }

}
