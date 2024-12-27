package week.week.year2023;

import java.util.*;
import java.util.stream.Collectors;

public class 有向无环图中一个节点的所有祖先2192 {

    TreeSet<Integer>[] ans;
    LinkedList<Integer>[] g;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ans = new TreeSet[n];
        g = new LinkedList[n];
        int[] inEdge = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList();
            ans[i] = new TreeSet();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            inEdge[e[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inEdge[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer fa = queue.poll();
            for (Integer son : g[fa]) {
                inEdge[son]--;
                ans[son].addAll(ans[fa]);
                ans[son].add(fa);
                if (inEdge[son] == 0) {
                    queue.add(son);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> list = ans[i].stream().collect(Collectors.toList());
            res.add(list);
        }
        return res;

    }

}
