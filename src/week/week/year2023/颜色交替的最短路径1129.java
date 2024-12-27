package week.week.year2023;

import java.util.Arrays;
import java.util.LinkedList;

public class 颜色交替的最短路径1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer>[][] edge = new LinkedList[n][2];
        boolean[][] vis = new boolean[n][2];
        for (LinkedList<Integer>[] e : edge) {
            Arrays.setAll(e, k -> new LinkedList<Integer>());
        }
        for (int[] redEdge : redEdges) {
            edge[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            edge[1][blueEdge[0]].add(blueEdge[1]);
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        int d = 0;
        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k--) {
                int[] poll = queue.poll();
                int i = poll[0], c = poll[1];
                vis[i][c] = true;
                if (ans[i] == -1) {
                    ans[i] = d;
                }
                c ^= 1;
                for (Integer son : edge[c][i]) {
                    if (vis[son][c]) continue;
                    queue.add(new int[]{son, c});
                }
            }
            d++;
        }
        return ans;
    }
}

class Test30 {
    public static void main(String[] args) {
        颜色交替的最短路径1129 test = new 颜色交替的最短路径1129();
        test.shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, null);
    }
}