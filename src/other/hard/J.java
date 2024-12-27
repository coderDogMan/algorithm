package other.hard;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] w = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            w[i] = in.nextInt();
        }

        //阶段 m
        //老师编号 n
        for (int i = 0; i < m; i++) {
            double max = -10000;
            int num = 0;
            for (int j = 0; j < n; j++) {
                double mq = -Math.cos(Math.abs(a[j] - w[i])) - Math.abs(a[j] - w[i]) + 114514;
                if (mq > max) {
                    max = mq;
                    num = j;
                }
            }
            System.out.print(num + 1 + " ");
        }
    }
}
