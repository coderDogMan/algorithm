package writtentest.jd2023;

import java.util.Scanner;

public class 棋盘 {
    static int n;
    static int m;
    static char[][] map;
    public static void main(String[] args) {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') {
                    for (int x = i; x < n; x++) {
                        for (int y = j + 1; y < m; y++) {
                            if (map[x][y] == 'X') {
                                if (check(i, j , x, y)) {
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int x1, int y1, int x2, int y2) {
        int x3 = x1 + y2 - y1;
        int y3 = y1 + x1 - x2;
        int x4 = x2 + y2 - y1;
        int y4 = y2 + x1 - x2;
        if (x3 >= 0 && x3 < n && x4 >= 0 && x4 < n && y3 >= 0 && y3 < m && y4 >= 0 && y4 < m){
            if (map[x3][y3] == 'X' && map[x4][y4] == 'X')
                return true;
        }
        return false;
    }

}
