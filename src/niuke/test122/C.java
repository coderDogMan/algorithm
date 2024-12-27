package niuke.test122;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            long n = in.nextInt();
            long m = in.nextInt();
            if (n == 1 || m == 1) {
                System.out.println(1);
            } else if (n == 2 || m == 2) {
                System.out.println((Math.max(n, m) + 1) / 2);
            } else if (n == 3 && m == 3) {
                System.out.println(8);
            } else {
                System.out.println(n * m);
            }

        }
    }
}
