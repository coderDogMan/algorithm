package week.week.year2023;

import java.util.PriorityQueue;

public class 购买物品的最大开销2931 {
    public long maxSpending(int[][] values) {
        int n = values.length;
        int m = values[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0;j < m; j++) {
                pq.add(values[i][j]);
            }
        }
        int step = 1;
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll() * step;
            step++;
        }
        return ans;
    }
}
