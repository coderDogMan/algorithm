package writtentest.xiaomi2024;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) A[i] = in.nextInt();
        for (int i = 0; i < n; i++) B[i] = in.nextInt();
        int ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] < a || B[i] < b) {
                l = i + 1;
            } else {
                if (i - l + 1 >= k) ans++;
            }
        }
        System.out.println(ans);

    }
}
