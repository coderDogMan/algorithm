package array.mid;

public class 螺旋矩阵II59 {
    public static void main(String[] args) {
        generateMatrix(5);
    }

    public static int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int num = 1;
        int len = n - 1;
        int i = 0, j = 0;
        for (; i < n / 2; ) {
            for (; j < len; j++) {
                res[i][j] = num++;
            }
            for (; i < len; i++) {
                res[i][j] = num++;
            }
            for (; j > n - len - 1; j--) {
                res[i][j] = num++;
            }
            for(; i > n - len - 1; i--) {
                res[i][j] = num++;
            }
            len--;
            i++;
            j++;
        }

        if (n % 2 != 0) res[n / 2][n / 2] = n * n;

        return res;
    }
}
