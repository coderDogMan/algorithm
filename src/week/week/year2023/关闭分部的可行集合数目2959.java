//package week.week;
//
//import java.util.Arrays;
//
//public class 关闭分部的可行集合数目2959 {
//    Integer INF = Integer.MAX_VALUE / 2;
//    public int numberOfSets(int n, int maxDistance, int[][] roads) {
//        int[][] g = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(g[i], INF);
//            g[i][i] = 0;
//        }
//        for (int[] road : roads) {
//            int x = road[0];
//            int y = road[1];
//            int w = road[2];
//            g[x][y] = w;
//            g[y][x] = w;
//        }
//        Integer.bitCount()
//
//
//    }
//}
