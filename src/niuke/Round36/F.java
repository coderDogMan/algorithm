package niuke.Round36;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < m; j++) {
                map[i][j] = (cur++ % 26);
            }
        }
        map[1][m - 1] = m % 26;
        map[2][m - 1] = m % 26;
        int k = m + 1;
        for (int i = 2; i < n; i++) {
            map[i][m - 2] = (++k % 26);
        }
        for (int i = 17; i < 26; i++) {
            if (i != map[n - 2][m - 2] && map[n - 1][ m - 1] != i) {
                map[n - 1][m - 2] = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((char) (map[i][j] + 'a') + " ");
            }
            System.out.println();
        }
    }
}
