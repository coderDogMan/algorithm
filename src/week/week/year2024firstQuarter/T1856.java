package week.week.year2024firstQuarter;

import java.util.LinkedList;

public class T1856 {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int MOD = (int) 1e9 +7;
        long ans = 0;
        int[] L = new int[n];
        int[] R = new int[n];
        long[] sum = new long[n + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) stack.pollLast();
            L[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.add(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peekLast()]) stack.pollLast();
            R[i] = stack.isEmpty() ? n : stack.peekLast();
            stack.add(i);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, nums[i] * (sum[R[i]] - sum[L[i] + 1]) % MOD);
        }
        return (int) ans;

    }
}

class Test34 {
    public static void main(String[] args) {
        T1856 test = new T1856();
        test.maxSumMinProduct(new int[]{1,2,3,2});
    }
}