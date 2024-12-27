package week.weektwo130;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: min
 * @Date:
 */
public class T2 {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = s.length();
        int[][] nodes = new int[n][3];
        for (int i = 0; i < n; i++) {
            nodes[i] = new int[] {points[i][0], points[i][1], s.charAt(i) - 'a'};
        }
        int l = 1, r = (int) 1e9 + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(nodes, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            if (Math.abs(nodes[i][0]) <= l && Math.abs(nodes[i][1]) <= l) {
//                ans++;
//            }
//        }
        return r;
//        return ans;
    }

    private boolean check(int[][] nodes, int mid) {
        int n = nodes.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nodes[i][2])) return false;
            if (Math.abs(nodes[i][0]) <= mid && Math.abs(nodes[i][1]) <= mid) {
                set.add(nodes[i][2]);
            }
        }
        return true;
    }

}
class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.maxPointsInsideSquare(new int[][]{{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}}, "abb");
//        t2.maxPointsInsideSquare(new int[][]{{1,1},{-2,-2},{-2,2}}, "abb");
    }
}
