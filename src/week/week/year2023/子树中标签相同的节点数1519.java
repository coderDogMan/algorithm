package week.week.year2023;

import java.util.LinkedList;

public class 子树中标签相同的节点数1519 {


    LinkedList<Integer>[] g;
    int[] ans;
    String s;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        g = new LinkedList[n];
        ans = new int[n];
        s = labels;
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<Integer>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(-1, 0);
        return ans;
    }

    private int[] dfs(int fa, int cur) {
        int[] map = new int[26];
        int idx = s.charAt(cur) - 'a';
        map[idx] = 1;
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            int[] sonNums = dfs(cur, son);
            for (int i = 0; i < 26; i++)
                map[i] += sonNums[i];
        }
        ans[cur] = map[idx];
        return map;
    }
}
