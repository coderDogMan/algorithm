package other.mid;

import java.util.Arrays;
import java.util.LinkedList;

public class 无重叠区间435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] == a2[0]) return a2[1] - a1[1];
            return a1[0] - a2[0];
        });
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                res++;
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            } else {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return res;
    }
}

