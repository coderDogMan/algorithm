package other.mid;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<Integer>();
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;
        while (ans.size() < m * n) {
            if (up <= down) {
                for (int i = left; i <= right; i++) ans.add(matrix[up][i]);
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= down; i++) ans.add(matrix[i][right]);
                right--;
            }
            if (up <= down) {
                for (int i = right; i >= left; i--) ans.add(matrix[down][i]);
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) ans.add((matrix[i][left]));
                left++;
            }
        }
        return ans;
    }
}

class Test8 {
    public static void main(String[] args) {
        螺旋矩阵54 test = new 螺旋矩阵54();
        test.spiralOrder(new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        });
//        test.spiralOrder(new int[][]{
//                {1,2,3},{4,5,6},{7,8,9}
//        });
    }
}