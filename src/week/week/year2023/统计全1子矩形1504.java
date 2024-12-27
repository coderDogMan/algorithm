package week.week.year2023;

public class 统计全1子矩形1504 {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] preSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                preSum[i][j] = j > 0 ? mat[i][j] == 0 ? 0 : preSum[i][j - 1] + 1 : mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (preSum[i][j] == 0) continue;
                int col = preSum[i][j];
                for (int k = i; i >= 0 && col != 0; k--) {
                    col = Math.min(col, preSum[k][j]);
                    ans += col;
                }
            }
        }
        return ans;
    }
}

class Test98 {
    public static void main(String[] args) {
        统计全1子矩形1504 test = new 统计全1子矩形1504();
        test.numSubmat(new int[][]{{1,1,1,1,0},{1,0,0,1,0},{0,0,1,0,1},{0,1,0,0,0}});
    }
}