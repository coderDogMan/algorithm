package array.easy;

public class 最大人工岛827 {

    public static void main(String[] args) {
        largestIsland(new int[][]{{1, 0},{1, 0}});
    }


    public static int largestIsland(int[][] grid) {
        int sum = 0;
        int isZero = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                sum += anInt;
                if (anInt == 0) isZero = 1;
            }
        }
        return sum + isZero;
    }
}
