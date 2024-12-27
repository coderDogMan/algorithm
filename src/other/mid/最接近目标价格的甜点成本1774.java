package other.mid;

import java.util.LinkedList;

public class 最接近目标价格的甜点成本1774 {
    int ans = Integer.MAX_VALUE / 2;
    int[] toppingCosts;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.toppingCosts = toppingCosts;
        for (int cost : baseCosts) {
            backtrack( 0, cost, target);

        }

        return ans;
    }

    private void backtrack(int startIdx, int sum, int target) {
        int a = Math.abs(ans - target), b = Math.abs(sum - target);
        if (b < a) ans = sum;
        if (a == b && sum < ans) ans = sum;
        if (sum > target) return;
        for (int i = startIdx; i < toppingCosts.length; i++) {
            backtrack(i + 1, sum + toppingCosts[i], target);
            backtrack(i + 1, sum + toppingCosts[i] * 2, target);
        }
    }
}

class Test49 {
    public static void main(String[] args) {
        最接近目标价格的甜点成本1774 test = new 最接近目标价格的甜点成本1774();
        System.out.println(test.closestCost(new int[]{1, 7}, new int[]{3, 4}, 10));
    }
}