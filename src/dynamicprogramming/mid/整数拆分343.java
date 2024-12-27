package dynamicprogramming.mid;

public class 整数拆分343 {
    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println(i);
    }

    public static int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(j * (i - j),dp[i]);
                dp[i] = Math.max(j * dp[i - j],dp[i]);
            }
        }
        return dp[n];
    }
}
