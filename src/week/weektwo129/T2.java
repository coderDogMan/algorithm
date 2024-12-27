package week.weektwo129;

public class T2 {

    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] col = new int[n + 1][m];
        int[][] row = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                col[i + 1][j] = grid[i][j] + col[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i][j + 1] = grid[i][j] + row[i][j];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    long up1 = col[i][j];
                    long down1 = col[n][j] - col[i + 1][j];
                    long r1 = row[i][m] - row[i][j + 1];
                    long l1 = row[i][j];
                    ans += up1 * r1 + down1 * r1 + up1 *l1 + down1 * l1;
                }
            }
        }
        return ans;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 test = new T2();
        test.numberOfRightTriangles(new int[][]{{0,1,0},{0,1,1},{0,1,0}});
    }
}
