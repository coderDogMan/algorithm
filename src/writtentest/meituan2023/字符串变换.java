package writtentest.meituan2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 字符串变换 {
    static int row;
    static int col;
    static char[][] map;
    static boolean[][] vis;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        LinkedList<int[]> marit = new LinkedList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int j = n / i;
            if (i * j == n) {
                marit.add(new int[]{i, j});
                marit.add(new int[]{j, i});

            }
        }
        int ans = Integer.MAX_VALUE;
        for (int[] size : marit) {
            row = size[0];
            col = size[1];
            map = new char[row][col];
            vis = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    map[i][j] = s.charAt(i * col + j);
                }
            }
            int max = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (vis[i][j]) continue;
                    dfs(i, j);
                    max++;
                }
            }
            ans = Math.min(ans, max);
        }
        System.out.println(ans);
    }

    private static void dfs(int i, int j) {
        if (vis[i][j]) return;
        vis[i][j] = true;
        if (i + 1 < row && map[i][j] == map[i + 1][j])
            dfs(i + 1, j);
        if (i - 1 >= 0 && map[i][j] == map[i - 1][j])
            dfs(i - 1, j);
        if (j + 1 < col && map[i][j] == map[i][j + 1])
            dfs(i, j + 1);
        if (j - 1 >= 0 && map[i][j] == map[i][j - 1])
            dfs(i, j - 1);
    }
}
