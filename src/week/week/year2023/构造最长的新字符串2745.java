package week.week.year2023;

import java.util.Arrays;

public class 构造最长的新字符串2745 {

//    public int longestString1(int x, int y, int z) {
//        int[][][] f = new int[x + 1][y + 1][z + 1];
//        f[0][0][0] = 1;
//        for (int i = 1; i <= x; i++) {
//            for (int j = 1; j <= y; j++) {
//                for (int k = 1; k <= z; k++) {
//                    if (x - i >= 0) f[i][j][z] = f[i - 1][j][z] + 2;
//                }
//            }
//        }
//
//
//    }


    int[][][][] memo;
    public int longestString(int x, int y, int z) {
        //
        memo = new int[3][x + 1][y + 1][z + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; i <= x; j++) {
                for (int k = 0; k <= y; k++)
                    Arrays.fill(memo[i][j][k],-1);
            }
        }
        int ans = 0;
        ans = Math.max(ans, dfs(0, x - 1, y, z) + 2);
        ans = Math.max(ans, dfs(1, x, y - 1, z) + 2);
        ans = Math.max(ans, dfs(2, x, y, z - 1) + 2);
        return ans;
    }

    private int dfs(int i, int x, int y, int z) {
        if (x == 0 || y == 0 || z == 0) return 0;
        if (memo[i][x][y][z] != -1) return memo[i][x][y][z];
        int ans = 0;

        if (i == 0) {
            ans = Math.max(ans, dfs(1, x, y - 1, z) + 2);
        } else {
            ans = Math.max(ans, dfs(0, x - 1, y, z) + 2);
            ans = Math.max(ans, dfs(2, x, y, z - 1) + 2);
        }
        memo[i][x][y][z] = ans;
        return ans;
    }
}
