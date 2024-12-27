package niuke.gjs1;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextInt() / 100D;
        double curx = 1;
        double ans = 0;
        long last = 0;
        for (int i = 1; i <= 100000; i++) {
            last += (2 * i - 1);
            ans += last * curx * x;
            curx = curx * (1 - x);
        }
        System.out.println(ans);


    }
}
