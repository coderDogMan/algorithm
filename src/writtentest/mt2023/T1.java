package writtentest.mt2023;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.next();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String s1 = arr[i][j];
                String s2 = arr[(i - 1 + n) % n][(j + m - 1) % m];
                for (int k = 0; k < a; k++)
                    if (s1.charAt(k) != s2.charAt(k)) ans++;
            }
        }
        System.out.println(ans);
    }
}
