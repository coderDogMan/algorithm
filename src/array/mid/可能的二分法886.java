package array.mid;

import java.util.ArrayList;
import java.util.List;

public class 可能的二分法886 {
    public static void main(String[] args) {
        boolean b = possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
        System.out.println(b);
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int curnode, int nowcolor, int[] color, List<Integer>[] g) {
        color[curnode] = nowcolor;
        for (int nextnode : g[curnode]) {
            if (color[nextnode] != 0 && color[nextnode] == color[curnode]) {
                return false;
            }
            if (color[nextnode] == 0 && !dfs(nextnode, 3 ^ nowcolor, color, g)) {
                return false;
            }
        }
        return true;
    }
}
