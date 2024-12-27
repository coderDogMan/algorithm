package week.week.year2023;

public class 构造乘积矩阵2906 {

    public static int MOD = (int) 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];
        long suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) suf;
                suf = suf * grid[i][j] % MOD;
            }
        }
        long pre = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) (p[i][j] * pre % MOD);
                pre = pre * grid[i][j] % MOD;
            }
        }
        return p;
    }
}

class Test95 {
    public static void main(String[] args) {
        构造乘积矩阵2906 test = new 构造乘积矩阵2906();
//        test.constructProductMatrix(new int[][]{{1,2},{3,4}});
        test.constructProductMatrix(new int[][]{{12345},{2},{1}});
    }
}