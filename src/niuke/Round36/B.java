package niuke.Round36;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[][] map = new int[n][m];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                sum += map[i][j];
            }
        }
        int XOR = map[0][0];
        for (int i = 1; i < m; i++) XOR ^= map[0][i];
        for (int i = 0; i < n; i++) {
            int xor = map[i][0];
            for (int j = 1; j < m; j++) {
                xor ^= map[i][j];
            }
            if (xor != XOR) {
                System.out.println("wrong answer");
                return;
            }
        }
        for (int j = 0; j < m; j++) {
            int xor = map[0][j];
            for (int i = 1; i < n; i++) {
                xor ^= map[i][j];
            }
            if (xor != XOR) {
                System.out.println("wrong answer");
                return;
            }
        }
        if (sum == x) {
            System.out.println("accepted");
        } else {
            System.out.println("wrong answer");
        }


    }
}
