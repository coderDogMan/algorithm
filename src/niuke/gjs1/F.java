package niuke.gjs1;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n % 2 == 0) {
            System.out.println(-1);
        } else {
            System.out.println((n - 1) / 2);
        }
    }

    private static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a;
            b >>= 1;
            a = a * a;
        }
        return res;
    }


}
