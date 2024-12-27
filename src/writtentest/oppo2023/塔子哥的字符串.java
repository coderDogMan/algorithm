package writtentest.oppo2023;

import java.util.Scanner;

public class 塔子哥的字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        long ans = 0;
        for (int i = 3; i < n; i++) {
            if (s.charAt(i) == 't' && s.charAt(i - 1) == 'z' && s.charAt(i - 2) == 'z' && s.charAt(i - 3) == 't') {
               ans += 1L * (i - 2) * (n - i);
            }
        }

        System.out.println(ans);

    }
}
