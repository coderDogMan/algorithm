package writtentest.xc2023;

import java.util.Scanner;

public class 塔子哥的好串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long ans = 0;
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cur++;
            } else {
                cur = Math.max(cur - 1, 0);
            }
            ans += cur;
        }
        System.out.println(ans);
    }
}
