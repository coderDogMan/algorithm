package writtentest.kuaishou;

import java.util.Scanner;

public class 塔子哥的矩阵 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] marit = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                marit[i][j] = in.nextInt();
        }
        int l = 0;
        int r = n - 1;
        int up = 0;
        int down = n - 1;
        int ans = 0;

        while (l < r) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            for (int i = l; i < r; i++)
                sb1.append(marit[l][i]);
            for (int i = up; i < down; i++) {
                sb2.append(marit[i][r]);
            }
            for (int i = r; i > l; i--) {
                sb3.append(marit[down][i]);
            }
            for (int i = down; i > up; i--) {
                sb4.append(marit[i][l]);
            }
            l++;
            r--;
            up++;
            down--;
            StringBuilder[] s = {sb1, sb2, sb3, sb4};
            for (int i = 0; i < sb1.length(); i++) {
                int num = 0;
                num += sb1.charAt(i) - '0';
                num += sb2.charAt(i) - '0';
                num += sb3.charAt(i) - '0';
                num += sb4.charAt(i) - '0';
                if (num == 1 || num == 3) {
                    ans += 1;
                } else if (num == 2) {
                    ans += 2;
                }
            }
        }
        System.out.println(ans);
    }
}
