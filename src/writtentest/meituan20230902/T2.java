package writtentest.meituan20230902;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String target = "meituan";
        int l = 0;
        for (int i = 0; i < n; i++) {
            String s = in.next();
            if (l < target.length() && s.indexOf(target.charAt(l)) != -1) {
                l++;
            }
        }
        System.out.println(l == target.length() ? "Yes" : "No");



    }
}
