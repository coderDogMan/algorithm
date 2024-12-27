package dynamicprogramming.easy;

public class 使用最小花费爬楼梯746 {
    public static void main(String[] args) {
        int i = minCostClimbingStairs(new int[]{10,15,20});
        System.out.println(i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return cost[0];
        int dp[] = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        int i = 2;
        for ( ; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[i - 1];
    }
}
