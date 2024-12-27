package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 工作计划的最低难度1335 {
    int[] jobDifficulty;
    int INF = Integer.MAX_VALUE / 2;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        this.jobDifficulty = jobDifficulty;
        int[][] f = new int[n + 1][d + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(f[i], INF);
        f[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            f[i][1] = Math.max(f[i - 1][1], jobDifficulty[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, d); j++) {
                for (int l = 1; i - l >= j - 1; l++)
                    f[i][j] = Math.min(f[i][j], f[i - l][j - 1] + max(l, i));
            }
        }
        return f[n][d] >= INF ? -1 : f[n][d];

    }

    private int max(int l, int r) {
        int max = 0;
        for (int i = 1; i <= l; i++) {
            max = Math.max(max, jobDifficulty[r - i]);
        }
        return max;
    }
}
class Test13 {
    public static void main(String[] args) {
        工作计划的最低难度1335 test = new 工作计划的最低难度1335();
        test.minDifficulty(new int[] {6,5,4,3,2,1}, 2);
    }
}
