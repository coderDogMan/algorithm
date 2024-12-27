package writtentest.elm2023;

import java.util.Scanner;

public class 送外卖 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String[] s1 = in.next().split(":");
            String[] s2 = in.next().split(":");
            String[] s3 = in.next().split(":");
            int t1 = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
            int t2 = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
            int t3 = Integer.parseInt(s3[0]) * 60 + Integer.parseInt(s3[1]);
            if (t1 <= 22 * 60) {
                if (t2 < t3) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                if (t2 < t3 && t2 > 22 * 60 && t2 < 24 * 60) System.out.println("Yes");
                else if (t2 > t3 && (t2 > 22 * 60 && t2 < 24 * 60) && t3 < 22 * 60) System.out.println("Yes");
                else if (t2 < t3 && t2 < 22 * 60) System.out.println("Yes");
                else System.out.println("No");
            }
        }

    }
}
