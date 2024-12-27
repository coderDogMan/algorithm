package other.mid;

public class 最大正方形221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dpLeft = new int[n][m];
        int[][] dpUp = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dpLeft[i][j] = matrix[i][j] - '0';
                    continue;
                }
                if (matrix[i][j] == '0')
                    dpLeft[i][j] = 0;
                else
                    dpLeft[i][j] = dpLeft[i][j - 1] + 1;
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dpUp[i][j] = matrix[i][j] - '0';
                    continue;
                }
                if (matrix[i][j] == '0')
                    dpUp[i][j] = 0;
                else
                    dpUp[i][j] = dpUp[i - 1][j] + 1;
            }
        }
        for (int i = 0; i < n && i < 2; i++)
            for (int j = 0; j < m && j < 2; j++)
                ans = Math.max(ans, matrix[i][j] - '0');

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    int area = Math.min(dpLeft[i][j - 1], dpUp[i - 1][j]) + 1;
                    ans = Math.max(ans, area * area);
                }
            }
        }
        return ans;
    }
}

