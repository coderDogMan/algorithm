package writtentest.SXF20231017;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static int INF = Integer.MAX_VALUE / 3;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.substring(1, s.length() - 1).split(", ");
        int[] nums = new int[split.length];
        int n = nums.length;
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(split[i]);
        int m = in.nextInt();
        int[] dp = new int[m + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= nums[i])
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        }
        System.out.println(dp[m] >= INF ? -1 : dp[m]);

    }
}
