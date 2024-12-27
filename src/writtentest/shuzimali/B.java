package writtentest.shuzimali;

import java.util.HashSet;
import java.util.Scanner;


public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        HashSet<Character> set = new HashSet<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (set.contains(s.charAt(i))) continue;
            set.add(s.charAt(i));
            System.out.print(s.charAt(i));
        }

    }
}
