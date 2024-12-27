package week.week.year2023;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 雇佣K位工人的总代价2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (n <= 2 * candidates) {
            int idx = 0;
            Arrays.sort(costs);
            while (k > 0) {
                ans += costs[idx++];
            }
            return ans;
        }


        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int l = 0, r = n - 1;
        for (; l < candidates;) {
            left.add(costs[l++]);
            right.add(costs[r--]);
        }
        while (l <= r && k > 0) {
            if (left.peek() <= right.peek()) {
                ans += left.poll();
                left.add(costs[l++]);
            } else {
                ans += right.poll();
                right.add(costs[r--]);
            }
            k--;
        }
        while (k > 0) {
            if (left.isEmpty()) {
                ans += right.poll();
            } else if (right.isEmpty()) {
                ans += left.poll();
            } else if (left.peek() <= right.peek()) {
                ans += left.poll();
            } else {
                ans += right.poll();
            }
            k--;
        }
        return ans;
    }
}
