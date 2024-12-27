package week.week341;

public class T1 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int num = 0;
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) sum++;
            }
            if (sum > num) {
                num = sum;
                index = i;
            }
        }

        return new int[]{index, num};
    }
}
