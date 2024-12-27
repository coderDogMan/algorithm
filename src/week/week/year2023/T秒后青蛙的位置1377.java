package week.week.year2023;



import javafx.util.Pair;

import java.util.LinkedList;

public class T秒后青蛙的位置1377 {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        LinkedList<Integer>[] g = new LinkedList[n + 1];
        boolean[] vis = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            g[i] = new LinkedList<>();
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        // 0 node  1几率
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair<>(1, 1.0));
        vis[1] = true;
        while (!queue.isEmpty() && t >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Double> poll = queue.poll();
                int cur = poll.getKey();
                double p = poll.getValue();
                int cnt = g[cur].size() - (cur == 1 ? 0 : 1);
                if (cur == target) {
                    if (t == 0 || cnt == 0) return p;
                    else return 0.0;
                }
                p = p / cnt;
                for (Integer son : g[cur]) {
                    if (vis[son]) continue;
                    queue.add(new Pair<>(son, p));
                    vis[son] = true;
                }
            }
            t--;
        }
        return 0.0;
    }
}

class Test77 {
    public static void main(String[] args) {
        T秒后青蛙的位置1377 test = new T秒后青蛙的位置1377();
//        test.frogPosition(8, new int[][]{[2,1],[3,2],[4,1],[5,1],[6,4],[7,1],[8,7]}, 7, 7);
        System.out.println(test.frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 2, 4));
    }
}