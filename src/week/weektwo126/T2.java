package week.weektwo126;

import java.util.PriorityQueue;

public class T2 {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = queries.length;
        long sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (nums[a] == nums[b]) return a - b;
            return nums[a] - nums[b];
        });
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            queue.add(i);
        }
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            int[] q = queries[i];
            sum -= nums[q[0]];
            nums[q[0]] = 0;
            queue.remove(q[0]);
            for (int j = 0; j < q[1] && !queue.isEmpty(); j++) {
                Integer idx = queue.poll();
                sum -= nums[idx];
                nums[idx] = 0;
            }
            res[i] = sum;
        }
        return res;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.unmarkedSumArray(new int[]{1,4,2,3}, new int[][]{{0, 1}});
    }
}