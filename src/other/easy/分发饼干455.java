package other.easy;

import java.util.Arrays;

public class 分发饼干455 {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < s.length; i++) {
            while (i < g.length && j < s.length &&  s[i] >= g[j]) {
                res++;
                i++;
                j++;
            }
        }
        return res;
    }
}
