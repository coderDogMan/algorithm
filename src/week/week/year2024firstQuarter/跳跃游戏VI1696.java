package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 跳跃游戏VI1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        f[0] = nums[0];
        stack.add(0);
        for (int i = 1; i < n; i++) {
            if (stack.getFirst() < i - k) stack.pollFirst();
            f[i] = f[stack.getFirst()] + nums[i];
            while (!stack.isEmpty() && f[i] > stack.getLast()) stack.pollLast();
            stack.add(i);
        }
        return f[n - 1];
    }

}
