package niuke.tow;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            int num = in.nextInt();
            if (num > 0) {
                int odd = 0;
                for (int i = 0; i < 32; i++) {
                    if ((num & 1) == 1) odd++;
                    num >>= 1;
                }
                if (odd % 2 != 0) System.out.println(1);
                else System.out.println(0);
            } else if (num < 0) {
                num = num ^ Integer.MAX_VALUE;
                int odd = 0;
                for (int i = 0; i < 31; i++) {
                    if ((num & 1) == 1) odd++;
                    num >>= 1;
                }
                if (odd % 2 != 0) System.out.println(1);
                else System.out.println(0);
            } else {
                System.out.println(0);
            }
        }
    }
}
