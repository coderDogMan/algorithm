package week.gsdc.test8;

import java.util.Scanner;

public class T6 {

    public static final long MOD = 998244353;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int a0 = in.nextInt();
            int a1 = in.nextInt();
            int k = in.nextInt();
            if (k == 0) {
                System.out.println(a0);
            } else if (k == 1) {
                System.out.println(a1);
            } else {
                long a = pow(2, k);

                System.out.println(((a - 1) * a1 % MOD - (a - 2) * a0 % MOD + MOD) % MOD);
            }
        }
    }

    private static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            b >>= 1;
            a = (a * a) % MOD;
        }

        return res;
    }
}
