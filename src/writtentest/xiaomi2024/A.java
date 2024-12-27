package writtentest.xiaomi2024;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        while (n-- > 0) {
            int op = in.nextInt();
            int m = in.nextInt();
            if (op == 1) {
                cnt += m;
            } else if (op == 2) {
                cnt -= (m <= cnt ? m : 0);
            } else if (op == 3) {
                cnt -= (cnt + m - 1) / m;
            }
        }
        System.out.println(cnt);



    }
}
