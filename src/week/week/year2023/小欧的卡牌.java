package week.week.year2023;

import java.util.Arrays;
import java.util.Scanner;

public class 小欧的卡牌 {

    public static final int MOD = (int) 1e9 + 7;
    static int[] A;
    static int[] B;
    static int k = 3;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        A = new int[n];
        B = new int[n];
        memo = new int[n][3];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            B[i] = in.nextInt();
        }

        System.out.println(dfs(n - 1, 0));
    }

    private static int dfs(int i, int mod) {
        if (i < 0) return mod == 0 ? 1 : 0;
        if (memo[i][mod] != -1) return memo[i][mod];
        long res = 0;
        res = dfs(i - 1, (mod + A[i]) % k);
        res += dfs(i - 1, (mod + B[i]) % k);
        memo[i][mod] = (int) res % MOD;
        return memo[i][mod];
    }
}
