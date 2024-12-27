package lqb.xiaobai6;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int T = scan.nextInt();
        while (T-- > 0) {
            long x = scan.nextLong();
            if ((x - 4) / 4 * 4 + 4 == x) {
                System.out.println("Yes");
                System.out.println((x / 4 - 1) + " " + (x / 4 + 1));
            } else {
                System.out.println("No");
            }


        }
        scan.close();
    }
}
