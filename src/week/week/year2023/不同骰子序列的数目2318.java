package week.week.year2023;

public class 不同骰子序列的数目2318 {

    public static final int MOD = (int) 1e9 + 7;
    int[][][] memo;
    public int distinctSequences(int n) {
        memo = new int[n][7][7];

        return dfs(n,  7, 7);
    }

    private int dfs(int i, int last1, int last2) {
        if (i == 0) return 1;
        if (memo[i][last1][last2] != 0) return memo[i][last1][last2];
        long res = 0;
        for (int j = 1; j <= 6; j++) {
            if (j != last1 && j != last2 && gcd(j, last1) == 1)
            res += dfs(i - 1, j, last1);
        }
        memo[i][last1][last2] = (int)(res % MOD);
        return memo[i][last1][last2];
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}

class Test45 {
    public static void main(String[] args) {
        不同骰子序列的数目2318 test = new 不同骰子序列的数目2318();
        System.out.println(test.gcd(4, 2));
    }
}