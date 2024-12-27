package niuke.牛客小白月赛88;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = new String[5];
        for (int i = 0; i < 5; i++) {
            strings[i] = in.nextLine();
        }
        if ((strings[1].charAt(0) == '0' || strings[1].charAt(0) == '1') && (strings[3].charAt(0) == '0' || strings[3].charAt(0) == '1')) {
            int a = strings[1].charAt(0) - '0';
            int b = strings[3].charAt(0) - '0';
            if (strings[2].contains("&")) {
                System.out.println(a & b);
            } else {
                System.out.println(a | b);
            }
        } else {
            int a = strings[2].charAt(0) - '0';
            if (a == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }




    }
}
