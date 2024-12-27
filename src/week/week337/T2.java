package week.week337;

import java.util.Date;

public class T2 {
        int num = 0;
        boolean[][] used;
        boolean flag = false;
        public boolean checkValidGrid(int[][] grid) {
            int n = grid.length;
            used = new boolean[n][n];
            dfs(grid, 0,0);
            return flag;
        }

        public void dfs(int[][] grid, int row, int col) {
            if (num == grid.length * grid.length) {
                flag = true;
            }
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != num || used[row][col]) {
                return;
            }
            num++;
            used[row][col] = true;
            dfs(grid, row + 2, col + 1);
            dfs(grid, row - 2, col + 1);
            dfs(grid, row + 2, col - 1);
            dfs(grid, row - 2, col - 1);

            dfs(grid, row + 1, col + 2);
            dfs(grid, row - 1, col + 2);
            dfs(grid, row + 1, col - 2);
            dfs(grid, row - 1, col - 2);
            num--;
        }
}

class Test2 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime());
//        T2 t2 = new T2();
//        t2.checkValidGrid(new int[][]{
//                {0,11,16,5,20},
//                {17,4,19,10,15},
//                {12,1,8,21,6},
//                {3,18,23,14,9},
//                {24,13,2,7,22}
//        });
//        t2.checkValidGrid(new int[][]{
//                { 0, 5,16, 7,10, 3},
//                {34,26, 1, 4,17, 8},
//                {24,15, 6, 9, 2,11},
//                {27,35,25,20,31,18},
//                {14,23,32,29,12,21},
//                {33,28,13,22,19,30}
//        });
    }
}