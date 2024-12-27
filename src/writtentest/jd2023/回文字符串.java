package writtentest.jd2023;

import java.util.Scanner;

public class 回文字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int ans = Integer.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < n; i++) {
            String s1;
            String s2;
            if (n % 2 == 0) {
                s1 = s.substring(0, n / 2);
                s2 = new StringBuilder(s.substring(n / 2)).reverse().toString();
            } else {
                s1 = s.substring(0, n / 2);
                s2 = new StringBuilder(s.substring(n / 2 + 1)).reverse().toString();
            }
            for (int j = 0; j < s1.length(); j++)
                if (s1.charAt(j) != s2.charAt(j)) min++;
            ans = Math.min(ans, min);
            s = s.substring(1, s.length()) + s.charAt(0);
            min = i + 1;
        }


        System.out.println(ans);
    }
}
