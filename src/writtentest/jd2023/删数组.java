package writtentest.jd2023;

import java.util.Arrays;
import java.util.Scanner;

public class 删数组 {
    public static final int MOD = (int) 1e9 + 7;
    static int[] nums;
    static int[][][] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        memo = new int[n][10][10];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 10; j++)
                Arrays.fill(memo[i][j], -1);
        for (int i = 0; i <= 9; i++)
            System.out.print(dfs(n - 2, nums[n - 1] % 10, i) + " ");
    }

    private static int dfs(int i, int last, int mod)  {
        if (i < 0) {
            if (last == mod) return 1;
            return 0;
        }
        if (memo[i][last][mod] != -1) return memo[i][last][mod];
        long res = dfs(i - 1, (nums[i] + last) % 10, mod);
            res += dfs(i - 1, (nums[i] * last) % 10, mod);
        memo[i][last][mod] = (int) ( res % MOD);
        return memo[i][last][mod];
    }
}
