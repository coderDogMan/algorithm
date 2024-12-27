package writtentest.mayi2023;

import java.util.Scanner;

public class 真实身份 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            if (s.charAt(x) == 'H') {
                if (s.charAt(y) == 'H') {
                    System.out.println("honester");
                } else {
                    System.out.println("liar");
                }
            } else {
                if (s.charAt(y) == 'H') {
                    System.out.println("liar");
                } else {
                    System.out.println("honester");
                }
            }
        }
    }
}
