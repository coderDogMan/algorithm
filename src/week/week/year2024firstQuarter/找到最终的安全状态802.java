package week.week.year2024firstQuarter;

import java.util.*;

public class 找到最终的安全状态802 {


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outEdge = new int[n];
        LinkedList<Integer>[] g = new LinkedList[n];
        Arrays.setAll(g, e -> new LinkedList());
        for (int i = 0; i < n; i++) {
            outEdge[i] = graph[i].length;
            for (int in : graph[i]) {
                g[in].add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (outEdge[i] == 0) {
            q.add(i);
            ans.add(i);
        }
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer node : g[poll]) {
                outEdge[node]--;
                if (outEdge[node] == 0) {
                    q.add(node);
                    ans.add(node);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

}
