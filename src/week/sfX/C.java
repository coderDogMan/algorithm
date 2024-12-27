package week.sfX;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    static int[][] edge;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int IFN = Integer.MAX_VALUE / 2;
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        edge = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(edge[i], IFN);
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            edge[u][v] = w;
        }
        dj(1, n);
    }

    private static void dj(int start, int end) {

        int x = -1;
    }
}
