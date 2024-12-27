package writtentest.meituan20240309;

import java.util.HashSet;
import java.util.Scanner;

public class T1 {

    static HashSet<Integer> dep;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dep = new HashSet<>();
        for (int i = 0; i < n; i++) dep.add(in.nextInt());
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            String s = in.next();
            System.out.println(check(s) ? "ok" : "error");
        }


    }

    private static boolean check(String s) {
        if (s.length() != 18) return false;
        if (!dep.contains(Integer.parseInt(s.substring(0, 6)))) return false;
        int time = Integer.parseInt(s.substring(6, 14));
        int y = Integer.parseInt(s.substring(6, 10));
        int m = Integer.parseInt(s.substring(10, 12));
        int d = Integer.parseInt(s.substring(12, 14));
        if (time < 19000101 || time > 20231231) return false;
        if (m == 2 && d == 29 && !(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0))) return false;
        int x = s.charAt(17) - '0';
        for (int i = 0; i < s.length() - 1; i++) {
            x = (x + s.charAt(i) - '0') % 8;
        }
        return x == 1;

    }

}
