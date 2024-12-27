package writtentest.kdxf2023;

import java.util.Scanner;

public class 塔子哥的区间 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            B[i] = in.nextInt();
        int l = 0;
        int r = n - 1;
        while (A[l] == B[l]) {
            l++;
        }
        while (A[r] == B[r]) {
            r--;
        }
        for (int i = l, j = r; i <= j; i++, j--) {
            if (A[i] != B[j]) {
                System.out.println(0);
                return;
            }
        }
        int ans = 0;
        for ( ;l >= 0 && r < n; l--, r++) {
            if (A[l] == B[r]) {
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
