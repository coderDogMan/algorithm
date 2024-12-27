package other.mid;

import java.util.Arrays;
import java.util.LinkedList;

public class 合并区间56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> (a1[0] - a2[0]));
        LinkedList<Integer> res = new LinkedList<>();
        res.add(intervals[0][0]);
        res.add(intervals[0][1]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (res.getLast() >= intervals[i + 1][0]) {
                int num = res.getLast();
                res.removeLast();
                res.add(Math.max(num, intervals[i + 1][1]));
            } else {
                res.add(intervals[i + 1][0]);
                res.add(intervals[i + 1][1]);
            }
        }
        int[][] result = new int[res.size() / 2][2];
        for (int i = 0; i < res.size(); i += 2) {
            result[i / 2][0] = res.get(i);
            result[i / 2][1] = res.get(i + 1);
        }
        return result;
    }
}
