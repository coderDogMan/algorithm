package week.week.year2023;

import java.util.HashSet;
import java.util.LinkedList;

public class 可能的二分法886 {
    static boolean[] vis;
    static int[] groups;
    static LinkedList<Integer>[] g;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        vis = new boolean[n + 1];
        groups = new int[n + 1];
        g = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new LinkedList();
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int[] dislike : dislikes) {
            g[dislike[0]].add(dislike[1]);
            g[dislike[1]].add(dislike[0]);
            set.add(dislike[0]);
            set.add(dislike[1]);
        }
        for (Integer i : set) {
            System.out.println("i=" + i + "     " + dfs(i, -1, groups[i]));
//            if (!dfs(1, -1, groups[0])) return false;
        }
        return true;



    }

    private boolean dfs(int i, int fa, int group) {
        if (vis[i] == true && group != groups[i]) return false;
        if (vis[i] == true) return true;
        vis[i] = true;
        groups[i] = group;
        for (Integer son : g[i]) {
            if (!dfs(son, i, group ^ 1)) return false;
        }
        return true;
    }
}
class Test40 {
    public static void main(String[] args) {
        可能的二分法886 test = new 可能的二分法886();
        test.possibleBipartition(4, new int[][]{{1,2},{3,1},{4,2}});
//        test.possibleBipartition(5, new int[][]{{1,2},{3,4},{4,5},{3,5}});
    }
}