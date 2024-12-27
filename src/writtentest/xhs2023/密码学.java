package writtentest.xhs2023;

import java.util.Scanner;

public class 密码学 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder(in.next());
        //97 98 99
        for (int i = 0; i < n; i++) {
            char c = sb.charAt(i);
            if (c < 100) {
                c = (char) ('z' + (c - 'a' - 2));
            } else {
                c = (char) (c - 3);
            }
            sb.replace(i, i + 1, c + "");
        }
        System.out.println(sb.toString());

    }
}
