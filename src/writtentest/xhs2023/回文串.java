package writtentest.xhs2023;

import java.util.Scanner;

public class 回文串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            String s = in.next();
            s = s.replace("w", "vv");
            s = s.replace("m", "nn");
            s = s.replace("p", "b");
            s = s.replace("q", "b");
            s = s.replace("d", "b");
            s = s.replace("u", "n");
            if (check(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean check(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
