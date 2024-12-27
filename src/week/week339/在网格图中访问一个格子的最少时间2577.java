//package week.week339;
//
//import java.util.Arrays;
//
//public class 在网格图中访问一个格子的最少时间2577 {
//    int[][] edge;
//    int INF = Integer.MAX_VALUE / 2;
//    public int minimumTime(int[][] grid) {
//
//
//    }
//
//    private int dijkstra(int start,int end, int n) {
//        int[] dit = new int[n];
//        Arrays.fill(dit, INF);
//        dit[start] = 0;
//        boolean[] vis = new boolean[n];
//        while (true) {
//            int x = -1;
//            for (int i = 0; i < n; i++) {
//                if (!vis[i] && (x < 0 || dit[i] < dit[x]))
//                    x = i;
//            }
//            if (dit[x] == INF || x < 0) return -1;
//            if (x == end) return dit[x];
//            for (int y = 0; y < n; y++) {
//                dit[y] = Math.min(dit[y], dit[x] + edge[x][y]);
//            }
//        }
//
//    }
//}
