package week.gsdc.test1;

import java.util.Scanner;

public class TD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            //固定k
            for (int k = 2; k <= n; k++) {
                check(k, n);
            }


        }


    }

    private static boolean check(int k, long n) {
        long r = n;
        long l = 1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if ((1 - Math.pow(k, mid)) == n * (1 - k)){
                return true;
            } if ((1 - Math.pow(k, mid)) > n * (1 - k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
