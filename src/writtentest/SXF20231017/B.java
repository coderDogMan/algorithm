package writtentest.SXF20231017;

import java.util.LinkedList;
import java.util.Scanner;

public class B {
    static String ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        ans = s;
        int n = s.length();
        char max = '9';
        for (; max >= '0'; max--) {
            if (s.contains(max + "")) break;
        }
        LinkedList<Integer> startList = new LinkedList<>();
        int start = -1;
        int maxLen = 0;
        for (int i = 0; i < n * 2; i++) {
            if (s.charAt(i % n) != max && start != -1) {
                if ((i - start + n) % n > maxLen) {
                    maxLen = (i - start + n) % n;
                    startList.clear();
                    startList.add(start % n);
                } else if (i - start == maxLen) {
                    startList.add(start % n);
                }
                start = -1;
            } else if (s.charAt(i % n) == max && start == -1) {
                start = i % n;
            }
        }

        for (Integer st : startList) {
           String temp =  s.substring(st, s.length()) + s.substring(0, st);
           if (temp.compareTo(ans) > 0)
               ans = temp;
        }
        System.out.println(ans);




    }
}
