package writtentest.mt2023;

import java.util.Scanner;

public class 田地行走 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] map = new int[n][m];
        while (k-- > 0) {
            int p = in.nextInt() - 1;
            int q = in.nextInt() - 1;
            map[p][q] = -1;
        }
        int startX = in.nextInt() - 1;
        int startY = in.nextInt() - 1;
        int endX = in.nextInt() - 1;
        int endY = in.nextInt() - 1;


    }
}
