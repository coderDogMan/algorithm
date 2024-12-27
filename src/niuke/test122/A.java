package niuke.test122;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (in.nextInt() == 1) cnt++;
            }
            System.out.println(Math.abs(m - 2 * cnt));
        }
    }
}
