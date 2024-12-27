package other.mid;

import java.util.LinkedList;

public class 子数组的最小值之和907 {
    public int sumSubarrayMins(int[] arr) {
        long MOD = (long) 1e9 + 7;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int n = arr.length;
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && arr[stack.getLast()] >= arr[i]) {
                R[stack.pollLast()] = i;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            R[stack.pollLast()] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[stack.getLast()] > arr[i]) {
                L[stack.pollLast()] = i;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            L[stack.pollLast()] = -1;
        }
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + ((long) arr[i] * (i - L[i]) * (R[i] - i))) % MOD;
        }
        return (int) ans;
    }
}
class Test37 {
    public static void main(String[] args) {
        子数组的最小值之和907 test = new 子数组的最小值之和907();
        test.sumSubarrayMins(new int[]{3,1,2,4});
    }
}
