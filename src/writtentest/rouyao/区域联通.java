package writtentest.rouyao;

import java.util.Arrays;
import java.util.Scanner;

public class 区域联通 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(map[i], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), v = in.nextInt();
            map[x][y] = Math.min(map[x][y], v); map[y][x] = Math.min(map[y][x], v);
        }
        boolean[] vis = new boolean[n + 1];
        int[] lowCost = new int[n + 1];
        Arrays.fill(lowCost, Integer.MAX_VALUE);
        int start = 1;      //起始点加入集合
        vis[start] = true;
        for (int i = 1; i <= n; i++) {      //根据起始点更新没有加入集合的点
            if (i == start) continue;
            lowCost[i] = Math.min(lowCost[i], map[i][start]);
        }
        int ans = 0, cnt = n - 1;       //cnt 集合外点的数量
        while (true) {
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {      //找没有加入集合的最小点
                if (!vis[j] && lowCost[j] < minVal) {
                    minIdx = j;
                    minVal = lowCost[j];
                }
            }
            if (minIdx == -1) {     //没有可以加入集合的点 根据集合外点的数量返回答案或-1
                System.out.println(cnt == 0 ? ans : -1);
                return;
            }
            ans += minVal;
            vis[minIdx] = true;       //把新的最小点放入集合
            cnt--;
            for (int j = 1; j <= n; j++) {      //更新没有加入的点到新加入集合点的最小距离
                if (!vis[j]) lowCost[j] = Math.min(lowCost[j], map[j][minIdx]);
            }
        }
    }
}
