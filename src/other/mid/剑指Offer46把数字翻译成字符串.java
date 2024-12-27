package other.mid;

import java.util.Arrays;

public class 剑指Offer46把数字翻译成字符串 {
    public int translateNum(int num) {
        if (num < 10) return 1;
        int n = (num + "").length();
        int[] dp = new int[n];
        int[] arr = new int[n];
        int index = n - 1;
        while (num > 0) {
            arr[index--] = num % 10;
            num /= 10;
        }
        Arrays.fill(dp, 1);
        if (arr[0] * 10 + arr[1] > 9 && arr[0] * 10 + arr[1] <= 25) {
            dp[1] = 2;
        }
        for (int i = 2; i < n; i++) {
            if (arr[i - 1] * 10 + arr[i] > 9 && arr[i - 1] * 10 + arr[i] <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
class Test2 {
    public static void main(String[] args) {
        剑指Offer46把数字翻译成字符串 test = new 剑指Offer46把数字翻译成字符串();
        test.translateNum(25);
        test.translateNum(624);
        test.translateNum(188580);
        test.translateNum(12258);
    }
}
