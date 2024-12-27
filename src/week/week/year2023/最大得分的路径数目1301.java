package week.week.year2023;

import java.util.LinkedList;
import java.util.List;

public class 最大得分的路径数目1301 {


    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = (int) 1e9 + 7;
        int n = board.size();
        int[][][] dp = new int[n][n][2];
        dp[n - 1][n - 1][1] = 1;
        int[][] points = new int[][] {{1, 0}, {0, 1}, {1, 1}};
        for (int j = n - 2; j >= 0 && board.get(n - 1).charAt(j) != 'X'; j--) {
            dp[n - 1][j][0] = dp[n - 1][j + 1][0] + board.get(n - 1).charAt(j) - '0';
            dp[n - 1][j][1] = 1;
        }
        for (int i = n - 2; i
                >= 0 && board.get(i).charAt(n - 1) != 'X'; i--) {
            dp[i][n - 1][0] = dp[i + 1][n - 1][0] + board.get(i).charAt(n - 1) - '0';
            dp[i][n - 1][1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'X') continue;

                int max = Math.max(dp[i + 1][j + 1][0], Math.max(dp[i + 1][j][0], dp[i][j + 1][0]));

                for (int[] point : points) {
                    if (dp[i + point[0]][j + point[1]][0] == max) {
                        dp[i][j][1] = (dp[i][j][1] + dp[i + point[0]][j + point[1]][1]) % MOD;
                    }
                }
                if (dp[i][j][1] > 0) {
                    int curr = Character.isDigit(c) ? c - '0' : 0;
                    dp[i][j][0] = max + curr;
                }

            }
        }
        return dp[0][0];
    }

}

class Test102 {
    public static void main(String[] args) {
        最大得分的路径数目1301 test = new 最大得分的路径数目1301();
        List<String> board = new LinkedList<>();
        board.add("E23");
        board.add("2X2");
        board.add("12S");
        test.pathsWithMaxScore(board);
    }
}