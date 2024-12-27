package week.week.year2023;

public class 统计构造好字符串的方案数2466 {



//    public int countGoodStrings(int low, int high, int zero, int one) {
//        int[] f = new int[high + 1];
//        f[0] = 1;
//        long ans = 0;
//        for (int i = 1; i <= high; i++) {
//            if (i >= zero) f[i] = (f[i] + f[i - zero]) % MOD;
//            if (i >= one) f[i] = (f[i] + f[i - one]) % MOD;
//            if (i >= low) ans += f[i];
//        }
//        return (int) (ans % MOD);
//    }

    public static final int MOD = (int) 1e9 + 7;

    int zero;
    int one;
    static int[] memo = new int[100000];
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.zero = zero;
        this.one = one;
//         = 0;

        long ans = dfs(high) - dfs(low - 1);

        return (int) (ans % MOD);
    }

    public int dfs(int i) {
        if (i < 0) return 0;
        if (i == 0) return 1;
        if (memo[i] != 0) return memo[i];
        long res = 0;
        res += dfs(i - zero) + dfs(i - one) + dfs(i - 1);
        memo[i] = (int) (res % MOD);
        return memo[i];
    }

}

class Test46 {
    public static void main(String[] args) {
        统计构造好字符串的方案数2466 test = new 统计构造好字符串的方案数2466();
        test.countGoodStrings(3,3,1,1);
    }
}