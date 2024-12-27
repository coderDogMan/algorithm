package week.weektwo128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class T4 {

    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] R = new int[n];
        Arrays.fill(R, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.getLast()]) {
                R[stack.pollLast()] = i;
            }
            stack.add(i);
        }
        boolean[] vis = new boolean[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            long cnt = 1;
            int j = i;
            while (R[j] < n && nums[i] == nums[R[j]]) {
                j = R[j];
                cnt++;
                vis[j] = true;
            }
            ans += (cnt + 1) * cnt / 2;
        }
        return ans;
    }
}

class Test4 {
    public static void main(String[] args) {
        T4 test = new T4();
        test.numberOfSubarrays(new int[]{1,4,3,3,2});
    }
}