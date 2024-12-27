package week.week.year2023;

import java.util.HashSet;
import java.util.LinkedList;

public class 转化数字的最小运算数2059 {

    public int minimumOperations(int[] nums, int start, int goal) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        HashSet<Integer> set = new HashSet<>();
        set.add(start);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int step = poll[1];
            for (int num : nums) {
                for (int v : new int[] {cur + num, cur - num, cur ^ num}) {
                    if (v == goal) return step + 1;
                    if (set.contains(v)) continue;
                    if (v <= 0 || v >= 1000) {
                        set.add(v);
                        continue;
                    }
                    queue.add(new int[] {v, step + 1});
                    set.add(v);
                }
            }
        }
        return -1;
    }

}
