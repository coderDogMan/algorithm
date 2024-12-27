package niuke.哈尔滨华德学院天梯赛选拔赛;

import java.util.Scanner;

public class 小雪买巧克力 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] value = new int[]{30, 50, 70};
        int[] weigth = new int[]{20, 25, 28};
        int[] dp = new int[n + 1];
        // 背包 j 物品的个数
        int[][] ans = new int[n + 1][3];
        for (int i = 0; i < 3; i++) {
            for (int j = weigth[i]; j <= n; j++) {
                if (dp[j] < dp[j - weigth[i]] + value[i]) {
                    dp[j] = dp[j - weigth[i]] + value[i];
                    if (dp[j] != dp[j - 1]) {
                        ans[j][i] += ans[j - 1][i] + 1;
                    } else {
                        ans[j][i] += ans[j - 1][i];
                    }
                } else {
                    dp[j] = dp[j];
                }
            }
        }

        System.out.println(ans);
    }
}

