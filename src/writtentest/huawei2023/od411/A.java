package writtentest.huawei2023.od411;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        int m = s.length() % n == 0 ? s.length() / n : s.length() / n + 1;
        char[][] map = new char[n][m];
        boolean flag = true;
        int i = 0;
        int j = 0;
        for (int k = 0; k < s.length(); k++) {
            map[i][j] = s.charAt(k);
            if (flag) {
                i++;
                if (i == n) {
                    i--;
                    j++;
                    flag = !flag;
                }
            } else {
                i--;
                if (i == -1) {
                    i++;
                    j++;
                    flag = !flag;
                }
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (!(map[i][j] <= 'Z'&& map[i][j] >= 'A')) continue;
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
