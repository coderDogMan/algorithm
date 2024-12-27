package niuke.test4;

import java.util.Scanner;

public class T5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mod = 998244353;
        int n = in.nextInt();
        int ans = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = i; j <= i + 6; j++) {
                ans += j;
            }
        }
        System.out.println(ans);

    }
}
