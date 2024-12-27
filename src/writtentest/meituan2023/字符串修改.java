package writtentest.meituan2023;

import java.util.Scanner;

public class 字符串修改 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int left = 0;
        int ans = 0;
        int i = 1;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(left)) {
                continue;
            } else {
                ans += (i - left) / 2;
                left = i;
            }
        }
        ans += (i - left) / 2;
        System.out.println(ans);

    }
}
