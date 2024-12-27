package week.week.year2023;

import java.util.ArrayList;

public class 将一个数字表示成幂的和的方案数2787 {

    public static final int MOD = (int) 1e9 + 7;
    public int numberOfWays(int n, int x) {
        int i = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (pow(i, x) <= n) {
            list.add(pow(i, x));
            i++;
        }
        int[] dp = new int[n + 1];
        for (i = 0; i < list.size(); i++) {
            for (int j = n; j >= list.get(i); j--) {
                dp[j] += Math.max(dp[j - list.get(i)] + list.get(i), dp[j]);
            }
        }
        return dp[n];

    }

    public int pow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            b >>= 1;
            a = (a * a ) % MOD;
        }
        return (int) res;
    }
}
class Test51 {
    public static void main(String[] args) {
        将一个数字表示成幂的和的方案数2787 test = new 将一个数字表示成幂的和的方案数2787();
        System.out.println(test.pow(2, 10));
    }
}
