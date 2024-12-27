package week.week.year2023;

import java.util.HashMap;
import java.util.LinkedList;

public class 喧闹和富有851 {
    LinkedList<Integer>[] edge;
    int[] quiet;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        this.quiet = quiet;
        int n = quiet.length;
        int[] ans = new int[n];
        edge = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new LinkedList();
        }
        for (int[] e : richer) {
            edge[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(i);
        }
        return ans;
    }
    //返回最小的人
    private int dfs(int fa) {
        if (map.containsKey(fa)) return map.get(fa);
        int person = fa;
        for (Integer son : edge[fa]) {
            int sonMin = dfs(son);
            if (quiet[person] > quiet[sonMin]) {
                person = sonMin;
            }
        }
        map.put(fa, person);
        return person;
    }
}
