package writtentest.mt2023;

import java.util.Scanner;

public class 分糖果 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int l = 1;
            int r = Math.max(a, b);
            while (l <= r) {
                int mid = (l + r) / 2;
                if (check(mid, a, b, n)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(r);
        }
    }

    private static boolean check(int mid, int a, int b, int n) {
        int i = 0;
        for (; i < n; i++) {
            if (a > 0) {
                a -= mid;
                if (a < 0) i--;
            } else if (b > 0) {
                b -= mid;
                if (b < 0) i--;
            } else {
                break;
            }
        }
        return i == n;
    }
}
