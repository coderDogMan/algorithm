package week.week392;

import java.util.Arrays;
import java.util.LinkedList;

public class T4 {
    int[] fa;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] ans = new int[query.length];
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        int[] and = new int[n];
        Arrays.fill(and, -1);
        for (int[] e : edges) {
            int x = find(e[0]);
            int y = find(e[1]);
            fa[x] = y;
            and[y] &= and[x];
            and[y] &= e[2];
        }
        for (int i = 0; i < query.length; i++) {
            int x = query[i][0], y = query[i][1];
            if (find(x) == find(y)) {
                ans[i] = and[find(y)];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
    private int find(int x) {
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}

class Test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.minimumCost(5, new int[][]{{0,1,7},{1,3,7},{1,2,1}}, new int[][] {{0,3},{3,4}});
    }
}
