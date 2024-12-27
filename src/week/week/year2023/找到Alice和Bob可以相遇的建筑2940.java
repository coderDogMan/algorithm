package week.week.year2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 找到Alice和Bob可以相遇的建筑2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int m = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ArrayList<int[]>[] left = new ArrayList[m];
        Arrays.setAll(left, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            Arrays.sort(query);
            if (heights[query[0]] < heights[query[1]]) {
                ans[i] = query[1];
            } else if (query[0] == query[1]) {
                ans[i] = query[1];
            } else {
                left[query[1]].add(new int[] {heights[query[0]], i});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < m; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                int[] poll = pq.poll();
                ans[poll[1]] = i;
            }
            for (int[] l : left[i]) {
                pq.add(l);
            }
        }
        return ans;
    }
}
