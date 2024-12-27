package niuke.牛客挑战赛73;

import java.util.Scanner;

public class A {
    static int N = (1000000 + 5);
    static boolean[] ok = new boolean[N];
    static {
        for (int i = 2; i < N; i++) {
            if (ok[i]) continue;
            for (int j = 2; i * j < N && i * j > 0; j++) {
                ok[i * j] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(1);
        } else if (ok[n + 1] == false) {
            System.out.println(n / 2);
        } else {
            System.out.println(1L * n * (n + 1) / 2);
        }

    }
}
