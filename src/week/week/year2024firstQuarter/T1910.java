package week.week.year2024firstQuarter;

import java.util.LinkedList;

public class T1910 {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();
        int[] next = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && part.charAt(j) != part.charAt(i)) {
                j = next[j - 1];
            }
            if (part.charAt(i) == part.charAt(j)) j++;
            next[i] = j;
        }
        StringBuilder sb = new StringBuilder();

        j = 0;
        LinkedList<Integer> js = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            while (j > 0 && s.charAt(i) != part.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == part.charAt(j)) j++;
            js.add(j);
            if (j == m) {
                while (j-- > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                    js.pollLast();
                }
                j = js.size() > 0 ? js.getLast() : 0;
            }
        }
        return sb.toString();
    }
}

class Test30 {
    public static void main(String[] args) {
        T1910 t1910 = new T1910();
        t1910.removeOccurrences("eemckxmckx", "emckx");
//        t1910.removeOccurrences("daabcbaabcbc", "abc");
    }
}