package writtentest.wangyi2023;

import java.util.Arrays;
import java.util.Scanner;

public class 魔法石Ⅰ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] diff = new int[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            start[i] = in.nextInt();
            ans += start[i];
        }
        for (int i = 0; i < n; i++) end[i] = in.nextInt();
        for (int i = 0; i < n; i++) diff[i] = end[i] - start[i];
        Arrays.sort(diff);
        for (int i = n - 1; i >= 0 && m > 0 && diff[i] > 0; i--) {
            ans += diff[i];
            m--;
        }
        System.out.println(ans);
    }
}
