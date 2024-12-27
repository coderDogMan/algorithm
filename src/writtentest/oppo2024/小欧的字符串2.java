package writtentest.oppo2024;

import java.util.Scanner;

public class 小欧的字符串2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        int k = in.nextInt();
        StringBuilder sb = new StringBuilder();
        if (k >= n - 1) {
            char last = s.charAt(n - 1);
            for (int i = 0; i < k - n + 1; i++) sb.append(last);
            for (int i = n - 2; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            if (check(s + sb)) {
                System.out.println(sb);
            } else {
                System.out.println(-1);
            }
        } else {
            int l = k;
            int r = n - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    System.out.println(-1);
                    return;
                }
                l++;
                r--;
            }
            for (int i = k; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            if (check(s + sb)) {
                System.out.println(sb);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static boolean check(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


}
