package week.week346;

public class 二进制矩阵中翻转最多一次使路径不连通2556 {
    int n;
    int m;
    public boolean isPossibleToCutPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
//        if (n == 1 || m == 1) {
//            return true;
//        }
        dfsRigth(grid, 0, 0);
        dfsDown(grid, 0, 0);
        if (grid[n - 1][m - 1] != 3) {
            return true;
        } else {
            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 3) num++;
                }
            }
            return num > 2;
        }

    }

    private boolean dfsDown(int[][] grid, int row, int col) {
        if (row >= n || col >= m) return false;
        if (grid[row][col] < 1) return false;
        grid[row][col]++;
        if (row == n - 1 && col == m - 1) return true;
        if (dfsDown(grid, row + 1, col)) return true;
        if (dfsDown(grid, row, col + 1)) return true;
        return false;
    }

    private boolean dfsRigth(int[][] grid, int row, int col) {
        if (row >= n || col >= m) return false;
        if (grid[row][col] != 1) return false;;
        grid[row][col]++;
        if (row == n - 1 && col == m - 1) return true;
        if (dfsRigth(grid, row, col + 1)) return true;
        if (dfsRigth(grid, row + 1, col)) return true;
        return false;
    }
}


class Test5 {
    public static void main(String[] args) {
        二进制矩阵中翻转最多一次使路径不连通2556 test = new 二进制矩阵中翻转最多一次使路径不连通2556();
        test.isPossibleToCutPath(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }

}
