package writtentest.jd2023;

import java.util.Arrays;
import java.util.Scanner;

public class 走棋 {
    static int n;
    static int m;
    static String[] map;
    static int[][][] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new String[n];
        memo = new int[n][m][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(memo[i][j], -1);
        for (int i = 0; i < n; i++) {
            map[i] = in.next();
        }
        // 0 是横 1 是纵
        System.out.println(Math.min(dfs(n - 1, m - 1, 0), Math.min(dfs(n - 1, m - 1, 1), dfs(n - 1, m - 1, 2))));

    }

    private static int dfs(int i, int j, int state) {
        if (i < 0  || j < 0  || map[i].charAt(j) == '*') {
            return Integer.MAX_VALUE / 2;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (memo[i][j][state] != -1) return memo[i][j][state];
        int res = dfs(i - 1, j, 1) + (state == 1 ? 0 : 1);
        res = Math.min(res,  dfs(i, j - 1, 0) + (state == 0 ? 0 : 1));
        res = Math.min(res,  dfs(i - 1, j - 1, 2) + (state == 2 ? 0 : 1));
        memo[i][j][state] = res;
        return res;
    }
}
