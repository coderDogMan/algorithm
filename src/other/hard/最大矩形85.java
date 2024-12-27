package other.hard;

import java.util.Arrays;
import java.util.LinkedList;

public class 最大矩形85 {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, maxMatrix(heights));
        }
        StringBuffer numString = new StringBuffer();
        return ans;
    }

    public int maxMatrix(int[] heights) {
        int n = heights.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (stack.size() != 0 && heights[stack.getLast()] > heights[i])
                r[stack.pollLast()] = i;
            stack.add(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() != 0 && heights[stack.getLast()] > heights[i])
                l[stack.pollLast()] = i;
            stack.add(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (r[i] - l[i] - 1) * heights[i]);
        }
        return ans;
    }
}
//class Test {
//    public static void main(String[] args) {
//        最大矩形85 test = new 最大矩形85();
//        int i = test.maximalRectangle(new char[][]{
//                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1','0','0','1','0'}
//        });
//        System.out.println(i);
//    }
//
//}