package writtentest.jd2023;

import java.util.Scanner;

public class 塔子哥划分 {
    static long[][] map;
    static long ans;
    static long sum;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        map = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int x = in.nextInt();
                sum += x;
                map[i][j] = x + map[i - 1][j] + map[i][ j - 1] - map[i - 1][j - 1];
            }
        }
        ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                find(i, j, sum / 2);
            }
        }
        System.out.println(ans);
    }

    private static void find(int i, int j, long target) {
        int l = 1;
        int r = Math.min(i, j);
        while (l <= r) {
            int mid = (l + r) / 2;
            int x = i - mid + 1;
            int y = j - mid + 1;
            long val = map[i][j] - map[x - 1][j] - map[i][y - 1] + map[x - 1][y - 1];
            ans = Math.min(ans, Math.abs(sum - 2 * val));
            if (val >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

    }

}
