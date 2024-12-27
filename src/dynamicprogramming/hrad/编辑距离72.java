package dynamicprogramming.hrad;

public class 编辑距离72 {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 表示word1 i - 1结尾的 和word2 j - 1的最小操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

class Test {
    public static void main(String[] args) {
        编辑距离72 test = new 编辑距离72();
        test.minDistance("", "a");

    }
}