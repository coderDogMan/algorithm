package week.week.year2023;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 将区间分为最少组数2406 {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(intervals[0]);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > queue.peek()[1]) {
                int[] poll = queue.poll();
                poll[1] = Math.max(poll[1], intervals[i][1]);
                queue.add(poll);
            } else {
                ans++;
                queue.add(intervals[i]);
            }
        }
        return ans;

    }
}

class Test {
    public static void main(String[] args) {
        将区间分为最少组数2406 test = new 将区间分为最少组数2406();
        test.minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}});
    }
}