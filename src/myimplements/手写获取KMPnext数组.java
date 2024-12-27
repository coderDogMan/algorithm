package myimplements;

import java.util.Arrays;

public class 手写获取KMPnext数组 {
    public static void main(String[] args) {
        int[] next = getNext("abcdaabcab");
        System.out.println(Arrays.toString(next));
    }

    public static int[] getNext(String s) {
        int next[] = new int[s.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 &&s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                next[i] = ++j;
            }else {
                next[i] = j;
            }
        }
        return next;
    }
}
