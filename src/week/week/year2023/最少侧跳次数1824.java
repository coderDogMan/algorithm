package week.week.year2023;

import java.util.Arrays;
import java.util.LinkedList;

public class 最少侧跳次数1824 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dis = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], n);
        }
        dis[0][1] = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        while (true) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            int d = dis[i][j];
            if (obstacles[i + 1] != j + 1 && d < dis[i + 1][j]) {
                dis[i + 1][j] = d;
                queue.add(new int[]{i + 1, j});
            }
            for (int k = j; k < j + 3 && d + 1 < dis[i][k % j]; k++) {
                dis[i][k % j] = d + 1;
                queue.add(new int[]{i, k % j});
            }
        }
    }
}

class Test29 {
    public static void main(String[] args) {
        最少侧跳次数1824 test = new 最少侧跳次数1824();
        test.minSideJumps(new int[]{0,1,2,3,0});
    }
}