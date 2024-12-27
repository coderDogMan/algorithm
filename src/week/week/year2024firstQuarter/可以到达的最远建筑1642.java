package week.week.year2024firstQuarter;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 可以到达的最远建筑1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum = 0;
        int i = 1;
        for (; i < n; i++) {
            int x = heights[i] - heights[i - 1];
            if (x > 0) {
                q.add(x);
                if (q.size() > ladders) sum += q.poll();
                if (sum > bricks) break;
            }
        }
        return i - 1;
    }
}

class Test23 {
    public static void main(String[] args) {
        可以到达的最远建筑1642 test = new 可以到达的最远建筑1642();
        test.furthestBuilding(new int[]{14,3,19,3}, 17, 0);
    }
}