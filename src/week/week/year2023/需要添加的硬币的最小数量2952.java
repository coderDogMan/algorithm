package week.week.year2023;

import java.util.Arrays;

public class 需要添加的硬币的最小数量2952 {

    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int s = 1;
        int i = 0;
        int ans = 0;
        while (s <= target) {
            if (i < coins.length && s >= coins[i]) {
                s += coins[i];
                i++;
            } else {
                s += s;
                ans++;
            }
        }
        return ans;

    }
}

class Test105 {
    public static void main(String[] args) {
        需要添加的硬币的最小数量2952 test = new 需要添加的硬币的最小数量2952();
        test.minimumAddedCoins(new int[]{1,1,1}, 20);
    }
}