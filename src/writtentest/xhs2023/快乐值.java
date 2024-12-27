package writtentest.xhs2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 快乐值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int T = in.nextInt();
        int H = in.nextInt();
        LinkedList<long[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            int h = in.nextInt();
            int a = in.nextInt();
            list.add(new long[]{t, h, a});
        }
        long[][] dp = new long[T + 1][H + 1];
        for (int k = 0; k < list.size(); k++) {
            long[] val = list.get(k);
            for (int i = T; i >= 0; i--) {
                for (int j = H; j >= 0; j--) {
                    if (i >= val[0] && j >= val[1])
                        dp[i][j] = Math.max(dp[i][j], dp[i - (int) val[0]][j - (int) val[1]] + val[2]);
                }
            }
        }
        System.out.println(dp[T][H]);

    }
}
