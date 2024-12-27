package week.weektwo120;

import java.util.Arrays;

public class T3 {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        long ans = 0;
        if (i == n) return 1L * (n + 1) * n / 2;
        for (int j = n - 1; j >= 0; j--) {
            if (j < n - 1 && nums[j] > nums[j + 1]) break;
            while (i >= 0 && nums[j] <= nums[i]) i--;
            ans += i + 2;
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
    }
}