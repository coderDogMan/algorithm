package week.week.year2023;

import java.util.Arrays;

public class 删除一次得到子数组最大和1186 {


    int[] arr;
    int[][] memo;
    public int maximumSum(int[] arr) {
        int n = arr.length;
        memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE / 2);
        }
        this.arr = arr;


        return Math.max(dfs(n - 1, 0), dfs(n - 1, 1));



    }

    private int dfs(int i, int j) {
        if (i < 0) return 0;
        if (memo[i][j] != Integer.MIN_VALUE / 2) return memo[i][j];
        int res = Integer.MIN_VALUE / 2;
        if (j == 0) {
            res = Math.max(0, dfs(i - 1, 0)) + arr[i];
        } else {
            res = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
        }
        memo[i][j] = res;
        return res;
    }


    public int maximumSum2(int[] arr) {
        if (arr.length == 1) return arr[0];
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(0, dp[i - 1][0]) + arr[i];
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i - 1], dp[i - 1][0]);
            ans = Math.max(dp[i][0], dp[i][1]);
        }
        return ans;
    }
}

class Test41 {
    public static void main(String[] args) {
        删除一次得到子数组最大和1186 test = new 删除一次得到子数组最大和1186();
        test.maximumSum(new int[]{2,1,-2,-5,-2});
//        test.maximumSum(new int[]{1,-2,0,3});
    }
}
