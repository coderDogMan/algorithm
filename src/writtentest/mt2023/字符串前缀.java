package writtentest.mt2023;

import java.util.Scanner;

public class 字符串前缀 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String S = in.next();
            String T = in.next();
            int ans = 0;
            int i = 0;
            for (; i < Math.min(S.length(), T.length()); i++) {
                if (S.charAt(i) != T.charAt(i)) {
                    ans++;
                }
            }
            if (i == S.length()) {
                System.out.println(ans);
            } else {
                System.out.println(ans + S.length() - i);
            }
        }
    }
}
