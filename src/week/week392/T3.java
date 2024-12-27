package week.week392;

import java.util.*;

public class T3 {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = n / 2;
        long ans = 0;
        if (nums[mid] < k) {
            for (int i = mid; i < n; i++) {
                if (nums[i] >= k) break;
                ans += k - nums[i];
            }
        } else {
            for (int i = mid; i >= 0; i--) {
                if (nums[i] <= k) break;
                ans += nums[i] - k;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 5, y = 5;
        y = ++x * --y;

        float f[][] = new float[6][6];
        System.out.println(x + " " + y);
    }
}
