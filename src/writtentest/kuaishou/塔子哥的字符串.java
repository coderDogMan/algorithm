package writtentest.kuaishou;

import java.util.Scanner;

public class 塔子哥的字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        int ans = Math.min(2, s.length());
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                char a = (char) (i + 'a');
                char b = (char) (j + 'a');
                int cnt = 0;
                boolean used = false;
                for (int k = 0; k < n; k++) {
                    if (!used && s.charAt(k) == a) {
                        used = true;
                        cnt++;
                    } else if (used && s.charAt(k) == b) {
                        cnt++;
                        used = false;
                    }
                }
                if (a != b && cnt % 2 == 1)
                    cnt--;
                ans = Math.max(ans, cnt);

            }
        }
        System.out.println(n - ans);
    }
}
