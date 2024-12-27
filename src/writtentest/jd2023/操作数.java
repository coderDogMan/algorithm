package writtentest.jd2023;

import java.util.Scanner;

public class 操作数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (y <= x) System.out.println(-1 + " " + -1);
            else System.out.println(1 + " " + (y - x));
        }

    }
}
