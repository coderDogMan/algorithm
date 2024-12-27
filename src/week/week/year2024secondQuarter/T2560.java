package week.week.year2024secondQuarter;

import java.util.Arrays;

/**
 * @Author: min
 * @Date:
 */
public class T2560 {

    int[] nums;
    int n, k;
    public int minCapability(int[] nums, int k) {
        this.nums = nums;
        n = nums.length;
        this.k = k;
        int l = 1, r = (int) 1e5;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid) {
        int[] f = new int[100001];
        if (nums[0] <= mid) f[0] = 1;
        if (nums.length >= 2) {
            if (nums[1] > mid)
                f[1] = f[0];
            else
                f[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] <= mid) {
                f[i] = Math.max(f[i - 1], f[i - 2] + 1);
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[n - 1] >= k;
    }
}
class Test4 {
    public static void main(String[] args) {
        T2560 test = new T2560();
        test.minCapability(new int[]{4,22,11,14,25}, 3);
//        test.minCapability(new int[]{2,7,9,3,1}, 2);
//        test.minCapability(new int[]{2,3,5,9}, 2);
    }
}
