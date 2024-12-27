package writtentest.meituan2023;

import java.util.Arrays;
import java.util.Scanner;

public class 构造数组 {
    public static int MOD = (int) 1e9 + 7;
    static int n;
    static int[] A;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            sum += A[i];
        }
        memo = new int[n][sum + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        System.out.println(dfs(0, sum));

    }

    private static int dfs(int i, int sum) {
        if (i == n) {
            if (sum == 0) return 1;
            return 0;
        }
        if (memo[i][sum] != -1) return memo[i][sum];
        long res = 0;
        for (int j = 1; j <= sum; j++) {
            if (A[i] == j) continue;
            res = (res + dfs(i + 1, sum - j)) % MOD;
        }
        memo[i][sum] = (int) res;
        return memo[i][sum];

    }
}
