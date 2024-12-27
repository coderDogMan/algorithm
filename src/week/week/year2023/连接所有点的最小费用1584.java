package week.week.year2023;

import java.util.Arrays;

public class 连接所有点的最小费用1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][1] - points[j][1]) + Math.abs(points[i][0] - points[j][0]);
                map[i][j] = dist;
                map[j][i] = dist;
            }
        }
        int[] lowCost = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(lowCost, Integer.MAX_VALUE);
        int start = 0;
        vis[start] = true;
        for (int i = 0; i < n; i++) {
            if (i == start) continue;
            lowCost[i] = Math.min(lowCost[i], map[i][start]);
        }
        int res = 0;
        while (true) {
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;
            // 找到没有加入集合的最小点
            for (int j = 0; j < n; j++) {
                if (!vis[j] && lowCost[j] < minVal) {
                    minIdx = j;
                    minVal = lowCost[j];
                }
            }
            if (minIdx == -1) {
                return res;
            }

            // 加入集合
            vis[minIdx] = true;
            res += minVal;
            //更新没有到集合的其他点
            for (int j = 0; j < n; j++) {
                if (!vis[j]) {
                    lowCost[j] = Math.min(lowCost[j], map[minIdx][j]);
                }
            }
        }
    }
}

class Test78 {
    public static void main(String[] args) {
        连接所有点的最小费用1584 test = new 连接所有点的最小费用1584();
        test.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}});
    }
}