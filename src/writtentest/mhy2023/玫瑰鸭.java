package writtentest.mhy2023;

import java.util.Scanner;

public class 玫瑰鸭 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int dif = Math.abs(a - b);
        if (c <= dif) {
            System.out.println((Math.min(a, b) + c) / 2);
        } else {
            c -= dif;
            int max = Math.max(a, b);
            max += c / 2;
            System.out.println(max / 2);
        }

    }
}
