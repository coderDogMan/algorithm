//package week.week;
//
//import java.util.LinkedList;
//
//public class 检查网格中是否存在有效路径1391 {
//    int[][] grid;
//    int m;
//    int n;
//    public boolean hasValidPath(int[][] grid) {
////        this.grid = grid;
////        n = grid.length;
////        m = grid[0].length;
////        LinkedList<int[]> queue = new LinkedList<>();
////        int[][] points = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
////        queue.add(new int[]{0, 0});
////        while (!queue.isEmpty()) {
////            int size = queue.size();
////            for (int i = 0; i < size; i++) {
////                int[] poll = queue.poll();
////                int x = poll[0];
////                int y = poll[1];
////                for (int[] point : points) {
////
////                }
////
////            }
////
////
////        }
//
////        dfs(grid, 0, 0);
//    }
//
////    1 - 3 5 4 6 1
////    2 - 3 4 5 6 2
////    3 - 1 4 5 6 2
////    4 - 1 3 5 6 2
////    5 - 2 3 4 6 1
////    6 - 2 3 4 5 1
////    private boolean dfs(int[][] grid, int x, int y) {
////        if (x == n - 1 && y == m - 1) return true;
////        if (x < 0 || x >= n || y < 0 || y >= m) return false;
////
////        dfs(grid, x + 1, y);
////        dfs(grid, x - 1, y);
////        dfs(grid, x, y - 1);
////        dfs(grid, x, y + 1);
////
////    }
//
//
//}
