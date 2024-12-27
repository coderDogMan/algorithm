package week.weektwo125;

import java.util.PriorityQueue;

public class T2 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add((long) num);
        }
        int ans = 0;
        while (queue.peek() < k) {
            long x = queue.poll();
            long y = queue.poll();
            queue.add(Math.min(x, y) * 2 + Math.max(x, y));
            ans++;
        }
        return ans;
    }

}
