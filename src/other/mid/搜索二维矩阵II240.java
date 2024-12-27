package other.mid;

import java.util.LinkedList;

public class 搜索二维矩阵II240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0; int right = matrix[0].length - 1;
        int up = 0; int down = matrix.length - 1;

        while (left <= right && up <= down) {
            int midHorizontal = left + (right - left) / 2;
            int midVertical = up + (down - up) / 2;
            if (matrix[midVertical][midHorizontal] == target) return true;
            else if (matrix[midVertical][midHorizontal] > target) {
                if (midHorizontal - 1 >= 0)
                    right = midHorizontal - 1;
                if (midVertical - 1 >= 0)
                    down = midVertical - 1;
            } else {
                if (midHorizontal + 1 <= right)
                    left = midHorizontal + 1;
                if (midVertical + 1 <= down)
                    up = midVertical + 1;
            }
        }
        return false;
    }
}

