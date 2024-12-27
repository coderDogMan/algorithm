package writtentest.mhy2023;

import java.util.Scanner;

public class 抽卡 {
    static double[] dp;
    static double p;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        p = in.nextDouble();
        dp = new double[181];
        double cur = 1;
        for (int i = 1; i < 90; i++) {
            dp[i] += (cur * p / 2);
            sol(cur * p / 2, i);
            cur *= (1 - p);
        }
        dp[90] += (cur / 2);
        sol(cur / 2, 90);
        double res = 0;
        for (int i = 1; i <= 180; i++)
            res += (dp[i] * i);
        System.out.println(res);

    }

    private static void sol(double cur, int idx) {

        for (int i =  1; i < 90; i++) {
            dp[i + idx] += (cur * p);
            cur *= (1 - p);
        }
        dp[idx + 90] += cur;
    }


}
