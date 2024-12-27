package other.hard;

import myimplements.HeapMin;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 柱状图中最大的矩形84 {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1); Arrays.fill(r, n);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.getLast()] > heights[i])
                r[stack.pollLast()] = i;
            stack.addLast(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.getLast()] > heights[i])
                l[stack.pollLast()] = i;
            stack.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (r[i] - l[i] - 1) * heights[i]);
        }
        return ans;
    }

}

