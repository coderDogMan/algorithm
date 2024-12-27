package niuke.week.Round34;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if ((s.charAt(i) - '0') % 2 == 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }

        }
        Collections.sort(list, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });
        for (String s1 : list) {
            System.out.println(s1);
        }

    }
}
