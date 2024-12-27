package writtentest.rouyao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 以物换物 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        String[] s = in.readLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(s[i]);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < nums[i]) continue;
                dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        }
        System.out.println(dp[n] != Integer.MAX_VALUE / 2 ? dp[n] : -1);

    }
}
