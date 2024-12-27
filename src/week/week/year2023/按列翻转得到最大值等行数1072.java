package week.week.year2023;

import java.util.HashMap;

public class 按列翻转得到最大值等行数1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            if (matrix[i][0] == 1) {
                for (int j = 0; j < m; j++) {
                    sb.append(matrix[i][j] ^ 1);
                }
            } else {
                for (int j = 0; j < m; j++) {
                    sb.append(matrix[i][j]);
                }
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            ans = Math.max(ans, map.get(key));
        }
        return ans;
    }
}

class Test57 {
    public static void main(String[] args) {
        按列翻转得到最大值等行数1072 test = new 按列翻转得到最大值等行数1072();
        test.maxEqualRowsAfterFlips(new int[][]{{0,0,0},{0,0,1} ,{1,1,0}});
    }
}