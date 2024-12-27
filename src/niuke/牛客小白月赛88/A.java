package niuke.牛客小白月赛88;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextInt();
        int n = in.nextInt();
        int[] food = new int[26];
        char ch = ' ';
        int val = 0;
        for (int i = 0; i < n; i++) {
            char c = in.next().charAt(0);
            int v = in.nextInt();
            if (v > val) {
                ch = c;
                val = v;
            }
        }
        if (x / val > 1000) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < Math.ceil(x / val); i++) {
                System.out.print(ch);
            }
        }




    }
}
