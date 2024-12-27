package week.week339;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 图中的最短环2608 {
    LinkedList<Integer>[] e;
    int n;
    public int findShortestCycle(int n, int[][] edges) {
        e = new LinkedList[n];
        this.n = n;
        Arrays.setAll(e, item -> new LinkedList<Integer>());
        for (int[] edge : edges) {
            e[edge[0]].add(edge[1]);
            e[edge[1]].add(edge[0]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, bfs(i));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    // i 为根节点， 环的数目
    private int bfs(int start) {
        int ans = Integer.MAX_VALUE;
        int[] dit = new int[n];
        Arrays.fill(dit, -1);
        dit[start] = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{-1, start});
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            int fa = val[0];
            int cur = val[1];
            for (Integer son : e[cur]) {
                if (son == fa) continue;
                if (dit[son] == -1) {
                    dit[son] = dit[cur] + 1;
                    queue.add(new int[]{cur, son});
                } else {
                    ans = Math.min(ans, dit[son] + dit[cur] + 1);
                }
            }
        }
        return ans;
    }
}

class Test2 {
    public static void main(String[] args) {
        图中的最短环2608 test = new 图中的最短环2608();
//        test.findShortestCycle(7, new int[][]{
//                {0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}
//        });
        test.findShortestCycle(4, new int[][]{
                {1,2},{0,1},{3,2},{1,3}
        });
    }
}
