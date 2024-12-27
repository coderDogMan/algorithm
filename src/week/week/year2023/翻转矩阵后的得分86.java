package week.week.year2023;

public class 翻转矩阵后的得分86 {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int j = 1; j < m; j++) {
            int zero = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 0) {
                    zero++;
                }
            }
            if (zero * 2 > n) {
                for (int i = 0; i < n; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = m - 1; j >= 0; j++) {
                if (grid[i][j] == 1) {
                    ans += k;
                }
                k = k * 2;
            }
        }
        return ans;
    }
}

class Test71 {
    public static void main(String[] args) {
        翻转矩阵后的得分86 test = new 翻转矩阵后的得分86();
        test.matrixScore(new int[][]{{0,0,1,1}, {1,0,1,0}, {1,1,0,0}});
    }
}