package niuke.Round35;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            if (i == s.length() / 2 - 1) {
                System.out.println();
            }
        }
    }

}
