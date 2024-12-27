package writtentest.xhs2023;

import java.util.Scanner;

public class 数学题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 50001;
        long[] ans = new long[N];
        int A = in.nextInt();
        int B = in.nextInt();
        int M = in.nextInt();
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < 50001; i++) {
            ans[i] = (ans[i - 1] * A + ans[i - 2] * B) % M;
        }
        int q = in.nextInt();
        while (q-- > 0) {
            int x = in.nextInt();
            System.out.print(ans[x] + " ");
        }

    }
}
