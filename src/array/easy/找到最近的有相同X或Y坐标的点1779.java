package array.easy;

public class 找到最近的有相同X或Y坐标的点1779 {
    public static void main(String[] args) {
        int i = nearestValidPoint(3, 6, new int[][]{{1, 3}, {9, 8}, {3, 8}, {3, 9}, {7, 4}, {3, 1}, {8, 1}});
        System.out.println(i);
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int value = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++)
            if(points[i][0] == x  || points[i][1] == y) {
                if (value > (Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y))) {
                    minIndex = i;
                    value = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                }
            }

        return minIndex;
    }
}
