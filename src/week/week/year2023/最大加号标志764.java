package week.week.year2023;

import java.util.Arrays;

public class 最大加号标志764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(map[i], 1);
        for (int[] mine : mines) {
            int x = mine[0];
            int y = mine[1];
            map[x][y] = 0;
        }
        //上面多少1
        int[][] up = new int[n][n];
        //下面多少1
        int[][] down = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && map[i][j] != 0 && up[i - 1][j] != 0) up[i][j] = up[i - 1][j] + 1;
                else if (map[i][j] != 0) up[i][j] = 1;
            }
        }
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = 0; j < n; j++) {
                if (i < n - 1 && map[i][j] != 0 && down[i + 1][j] != 0) down[i][j] = down[i + 1][j] + 1;
                else if (map[i][j] != 0) down[i][j] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n ; i++) {
                if (j > 0 && map[i][j] != 0 && left[i][j - 1] != 0) left[i][j] = left[i][j - 1] + 1;
                else if (map[i][j] != 0) left[i][j] = 1;
            }
        }
        for (int j = n - 1; j >= 0 ; j--) {
            for (int i = 0; i < n ; i++) {
                if (j < n - 1 && map[i][j] != 0 && map[i][j + 1] != 0) right[i][j] = right[i][j + 1] + 1;
                else if (map[i][j] != 0) right[i][j] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, min(up[i][j], down[i][j], left[i][j], right[i][j]));
            }
        }
        return ans;
    }

    private int min(int i, int i1, int i2, int i3) {
        return Math.min(Math.min(i, i1), Math.min(i2, i3));
    }
}

class Test16 {
    public static void main(String[] args) {
        最大加号标志764 test = new 最大加号标志764();
        test.orderOfLargestPlusSign(2, new int[][]{{0,0},{0,1},{1,0}});
//        test.orderOfLargestPlusSign(5, new int[][]{{4, 2}});
    }
}