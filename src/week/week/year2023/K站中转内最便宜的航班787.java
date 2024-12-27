package week.week.year2023;

import java.util.Arrays;

public class K站中转内最便宜的航班787 {

    int INF = Integer.MAX_VALUE / 2;
    int N = 110;
    int[][] edge;
    int[] dist;
    int n, src, dst, k;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.n = n;
        this.src = src;
        this.dst = dst;
        this.k = k;
        dist = new int[n];
        edge = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                edge[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] f : flights) {
            edge[f[0]][f[1]] = f[2];
        }
        int ans = bf();
        return ans > INF ? -1 : ans;
    }

    private int bf() {
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int limit = 0; limit < k; limit++) {
//            int[] clone = dist.clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[j] = Math.min(dist[j], edge[i][j] + dist[i]);
                }
            }
        }
        return dist[dst];
    }



}

class Test32 {
    public static void main(String[] args) {
        K站中转内最便宜的航班787 test = new K站中转内最便宜的航班787();
        test.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1);
    }
}