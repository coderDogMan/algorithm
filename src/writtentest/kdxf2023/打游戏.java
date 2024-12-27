package writtentest.kdxf2023;

import java.util.Scanner;

public class 打游戏 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        for (int i = 1; i < n; i++) {
            k -= (s.charAt(i) - s.charAt(i - 1));
            if (k < 0) break;
        }
        System.out.println(k < 0 ? -1 : k);
    }
}
