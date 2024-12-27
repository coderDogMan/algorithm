package week.week373;

public class T1 {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        k %= m;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = k; j < m + k; j++) map[i][j - k] = mat[i][j % m];
            } else {
                for (int j = m - k; j < 2 * m - k; j++) {
                    map[i][j - m + k] = mat[i][j % m];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != mat[i][j]) return false;
            }
        }
        return true;
    }
}
class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.areSimilar(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 2);
    }
}
