package other.mid;

import java.util.HashMap;
import java.util.Set;

public class 剑指OfferII013二维子矩阵的和 {
    int[][] perfix;
    int n;
    int m;
    public 剑指OfferII013二维子矩阵的和(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        perfix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                perfix[i][j] = perfix[i - 1][j] + perfix[i][j - 1] - perfix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int area1 = perfix[row2 + 1][col2 + 1];
        //左
        int area2 = perfix[row2 + 1][col1];
        //右
        int area3 = perfix[row1][col2 + 1];
        //min
        int area4 = perfix[row1][col1];
        return area1 - area2 - area3 + area4;
    }
}

class Test14 {
    public static void main(String[] args) {
        剑指OfferII013二维子矩阵的和 test = new 剑指OfferII013二维子矩阵的和(new int[][]{
                {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}
        });

    }
}