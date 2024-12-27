package lqb.mid;

import java.util.LinkedList;
import java.util.Scanner;

public class 迷宫 {
    static int n;
    static double sum;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        int[][] dp = new int[n][n];
        bfs(dp, n - 1, n - 1, 0);
        dp[n - 1][n - 1] = 0;
        sum -= 2;
        for (int i = 0; i < m; i++) {
            int x1 = in.nextInt() - 1;
            int y1 = in.nextInt() - 1;
            int x2 = in.nextInt() - 1;
            int y2 = in.nextInt() - 1;
            bfsOne(dp, x2, y2, dp[x1][y1] + 1);
            bfsOne(dp, x1, y1, dp[x2][y2] + 1);
        }

        System.out.printf("%.2f", sum / (n * n));
    }

    private static void bfs(int[][] dp, int row, int col, int val) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                sum -= dp[x][y];
                dp[x][y] = val;
                sum += val;
                if (x + 1 >= 0 && x + 1 < n && dp[x + 1][y] == 0) {
                    queue.add(new int[]{x + 1, y});
                }
                if (y + 1 >= 0 && y + 1 < n && dp[x][y +1] == 0) {
                    queue.add(new int[]{x, y + 1});
                }
                if (x - 1 >= 0 && x - 1 < n && dp[x - 1][y] == 0) {
                    queue.add(new int[]{x - 1, y});
                }
                if (y - 1 >= 0 && y - 1 < n && dp[x][y - 1] == 0) {
                    queue.add(new int[]{x, y - 1});
                }
            }
            val++;
        }
    }

    //更新点 更新值
    private static void bfsOne(int[][] dp, int row, int col, int val) {
        if (dp[row][col] <= val) return;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                if (dp[x][y] <= val) {
                    continue;
                }
                sum -= dp[x][y];
                dp[x][y] = val;
                sum += val;
                if (x + 1 >= 0 && x + 1 < n && dp[x + 1][y] > val) {
                    queue.add(new int[]{x + 1, y});
                }
                if (y + 1 >= 0 && y + 1 < n && dp[x][y + 1] > val) {
                    queue.add(new int[]{x, y + 1});
                }
                if (x - 1 >= 0 && x - 1 < n && dp[x - 1][y] > val) {
                    queue.add(new int[]{x - 1, y});
                }
                if (y - 1 >= 0 && y - 1 < n && dp[x][y - 1] > val) {
                    queue.add(new int[]{x, y - 1});
                }
            }
            val++;
        }
    }
}
