package writtentest.xhs2023;

import java.util.Scanner;

public class X排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int point = 1;
            for (int i = 0; i < n; i++)
                if (in.nextInt() == point) point++;
            point--;
            if ((n - point) % x == 0) {
                System.out.println((n - point) / x);
            } else {
                System.out.println((n - point) / x + 1);
            }
        }
    }
}
