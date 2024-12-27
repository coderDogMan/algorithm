package week.week341;

import java.util.ArrayList;

public class T4 {

    int[] price;
    int max;
    ArrayList<Integer>[] edge;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        edge = new ArrayList[n];
        for (int i = 0; i < n; i++){
            edge[i] = new ArrayList<>();
        }
        this.price = price;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            edge[u].add(v);
            edge[v].add(u);
        }
        max = getSum(0, -1);
        int[] p1 = new int[price.length];
        int[] p2 = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            p1[i] = price[i];
            p2[i] = price[i];
        }
        change(0, -1, true, p1);
        p2[0] /= 2;
        change(0, -1, false, p2);
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < price.length; i++) {
            sum1 += p1[i];
            sum2 += p2[i];
        }
        if (sum1 > sum2) {
            price = p2;
        } else {
            price = p1;
        }
        int ans = 0;
        for (int[] trip : trips) {
            int len = price[trip[0]];
            int num = dfs(trip[0], -1, trip[1], len);
            ans += num;
        }

        return ans;
    }

    private int dfs(int start, int fa, int end, int len) {
        int ans = -1;
        for (Integer son : edge[start]) {
            if (son == fa) continue;
            if (son == end) return len + price[son];

            int sonLen = dfs(son, start, end, len + price[son]);
            if (sonLen != -1) {
                ans = sonLen;
            }
        }
        return ans;
    }

    private void change(int node, int fa, boolean flag, int[] p1) {
        for (Integer son : edge[node]) {
            if (son == fa) continue;
            if (flag) {
                p1[son] /= 2;
            }
            change(son, node, !flag, p1);
        }
    }

    private int getSum(int node, int fa) {
        int ans = price[node];
        for (Integer son : edge[node]) {
            if (son == fa) continue;
            ans += getSum(son, node);

        }
        return ans;
    }
}

class Test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.minimumTotalPrice(4,new int[][]{{0,1},{1,2},{1,3}}, new int[]{2,2,10,6}, new int[][]{{0,3},{2,1},{2,3}});
    }
}