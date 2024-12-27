package week.weektwo104;

import java.util.HashSet;

public class T3 {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] | nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] | nums[i + 1];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long l = L[i];
            long r = R[i];
            long num = nums[i];
            ans = Math.max(ans, l | r | (num <<= k));
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 test = new T3();
//        test.maximumOr(new int[]{12,9}, 1);
        test.maximumOr(new int[]{8,1,2}, 2);
    }
}