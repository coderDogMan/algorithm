package niuke.Round36;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z' && sb.charAt(i - 1) != ' ') {
                ans++;
                sb.setCharAt(i, ' ');
            }
        }
        System.out.println(ans);
    }
}
