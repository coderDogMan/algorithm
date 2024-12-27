package week.weektwo99;

public class 统计染色格子数6311 {
    public long coloredCells(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + i * 4 - 4;
        return dp[n];
    }
}
//class Test {
//    public static void main(String[] args) {
//        统计染色格子数6311 test = new 统计染色格子数6311();
//        System.out.println(test.coloredCells(1));
//        System.out.println(test.coloredCells(2));
//        System.out.println(test.coloredCells(3));
//        System.out.println(test.coloredCells(4));
//    }
//}