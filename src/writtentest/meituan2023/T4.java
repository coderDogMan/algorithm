package writtentest.meituan2023;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] X = new int[n];
        int[] Y = new int[n];
        int[] Z = new int[n];
        int[] need = new int[n];
        for (int i = 0; i < n; i++) {
            X[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            Y[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            Z[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            need[i] = X[i] - Y[i];
        }
        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int idx = in.nextInt() - 1;
            long ans = (long) need[idx] * Z[idx];
            long num = need[idx];
            for (int j = idx - 1; j >= 0; j--) {
                ans = Math.min(ans, (need[j] + num) * Z[j]);
                num += need[j];
            }
            System.out.print(ans + " ");
        }
    }
}
