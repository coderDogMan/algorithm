package writtentest.threeSixZero;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n-- > 0) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            String op1 = in.next();
            String op2 = in.next();
            if (Math.abs(x1 - x2) > 100000 || Math.abs(y1 - y2) > 100000) {
                System.out.println("Not Over");
                break;
            };

            int i = 0;
            if (x1 == x2 && y1 == y2) {
                System.out.println(i);
                break;
            }
            for (i = 0; i < op1.length(); i++) {
                char c1 = op1.charAt(i);
                if (c1 == 'D') {
                    x1++;
                } else if (c1 == 'W') {
                    y1++;
                } else if (c1 == 'A') {
                    x1--;
                } else if (c1 == 'S') {
                    y1--;
                }

                char c2 = op2.charAt(i);
                if (c2 == 'D') {
                    x2++;
                } else if (c2 == 'W') {
                    y2++;
                } else if (c2 == 'A') {
                    x2--;
                } else if (c2 == 'S') {
                    y2--;
                }
                if (x1 == x2 && y1 == y2) {
                    System.out.println(i + 1);
                    break;
                }
            }
            if (i == op1.length() && (x1 != x2 || y1 != y2)) System.out.println("Not Over");
        }


    }

}
