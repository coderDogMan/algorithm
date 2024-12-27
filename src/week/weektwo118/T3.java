package week.weektwo118;

import java.util.Arrays;

public class T3 {
    int[] prices;
    int[] memo;
    public int minimumCoins(int[] prices) {
        this.prices = prices;
        memo = new int[1001];
        Arrays.fill(memo, -1);

        return dfs(1);
    }

    private int dfs(int i) {
        if (i * 2 >= prices.length) return 0;
        if (memo[i] != -1) return memo[i];
        int min = Integer.MAX_VALUE;
        int res = prices[i - 1];
        for (int j = i + 1; j < 2 * i + 1; j++) {
            min = Math.min(min, Math.min(dfs(j), dfs(j) + prices[j - 1]));
        }
        return memo[i] = res + min;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.minimumCoins(new int[] {3,1,2});
    }
}