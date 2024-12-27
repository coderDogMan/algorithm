package week.gsdc.test1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class TC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] F = new int[1000006];
        for (int i = 0; i < n; i++) {
            int idx = in.nextInt();
            while (F[idx] == 1) {
                F[idx] = 0;
                idx++;
            }
            F[idx] = 1;
        }
        int ans = 0;
        for (int i = 0; i < 1000006; i++) {
            if (F[i] == 1) ans++;
        }
        System.out.println(ans);
    }
}
