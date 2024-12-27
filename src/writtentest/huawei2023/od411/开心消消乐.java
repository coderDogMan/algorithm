package writtentest.huawei2023.od411;

import java.util.Scanner;

public class 开心消消乐 {

    static int[][] map;
    static int ans;
//    static int sum;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][m];
        ans = 0;
//        sum = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
//                if (map[i][j] == 0) sum--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    ans++;
                    dfs(i, j);
                }
            }

        }

        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (map[x][y] == 0) return;
        map[x][y] = 0;
//        sum--;
        dfs(x + 1, y);
        dfs(x + 1, y + 1);
        dfs(x + 1, y - 1);
        dfs(x - 1, y);
        dfs(x - 1, y + 1);
        dfs(x - 1, y - 1);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
