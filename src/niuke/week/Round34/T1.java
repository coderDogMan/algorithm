package niuke.week.Round34;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String a = s.charAt(0) + "";
        String b = s.charAt(2) + "";
        System.out.println(4);
        System.out.println(a);
        if (!a.equals(b)) {
            System.out.println(b);
            System.out.println(b + a);
        }
        System.out.println(a + b);
    }

}
