package writtentest.oppo2023;

import java.util.Scanner;

public class 小欧的平均数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int odl = 0;
        if (x % 2 == 1) odl++;
        if (y % 2 == 1) odl++;
        if (z % 2 == 1) odl++;
        if (odl == 0 || odl == 3) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
