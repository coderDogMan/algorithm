package writtentest.meituan2023;

import java.util.Scanner;

public class 循环序号 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int m = in.nextInt();
            int n = in.nextInt();
            if (n % m == 0) {
                System.out.println(m);
            } else {
                System.out.println(n % m);
            }
        }


    }
}
