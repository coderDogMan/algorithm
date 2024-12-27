package week.week390;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class T3 {

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        long[] ids = new long[100000 + 1];
        int n = nums.length;
        long[] ans = new long[n];
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(b[1], a[1]));
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ids[nums[i]] += freq[i];
            map.put((long) nums[i], ids[nums[i]]);
            queue.add(new long[]{nums[i], ids[nums[i]]});
            while (!queue.isEmpty() && map.get(queue.peek()[0]) != queue.peek()[1]) queue.poll();
            ans[i] = queue.size() > 0 ? queue.peek()[0] : 0;
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.mostFrequentIDs(new int[]{2,3,2,1}, new int[]{3,2,-2,1});
    }
}