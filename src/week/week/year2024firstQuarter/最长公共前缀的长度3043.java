package week.week.year2024firstQuarter;

import java.util.HashMap;
import java.util.HashSet;

public class 最长公共前缀的长度3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < m; i++) {
            int x = arr2[i];
            while (x > 0) {
                set.add(x);
                x /= 10;
            }
        }
        int mx = 0;
        for (int i = 0; i < n; i++) {
            int x = arr2[i];
            while (x > 0 && !set.contains(x)) x /= 10;
            mx = Math.max(mx, x);
        }
        return String.valueOf(mx).length();
    }
}
