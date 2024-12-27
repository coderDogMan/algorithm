package sort.esay;

import java.util.Arrays;

public class 分发饼干455 {
    public static void main(String[] args) {
        int contentChildren = findContentChildren(new int[]{1, 2}, new int[]{1,2,3});
        System.out.println(contentChildren);
    }

//    public static int findContentChildren(int[] g, int[] s) {}

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i != g.length && j != s.length) {
            if (g[i] <= s[j]) {
                i++;j++;count++;
            }else {
                j++;
            }
        }

        return count;
    }
}
