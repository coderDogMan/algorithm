package week.week.year2023;

import java.util.Arrays;

public class 网格图中递增路径的数目2328 {


    public static final int MOD = (int) 1e9 + 7;
    int[][] points = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int n;
    int m;
    int[][] grid;
    long[][] memo;
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        memo = new long[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        this.grid = grid;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = (ans + dfs(i, j)) % MOD;
            }
        }
        return (int) (ans);
    }

    private long dfs(int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];
        long res = 1;
        for (int[] point : points) {
            int x = i + point[0];
            int y = j + point[1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > grid[i][j]) {
                res += dfs(x, y);
            }
        }
        memo[i][j] = res;
        return res;
    }
}


class Test53 {
    public static void main(String[] args) {
        网格图中递增路径的数目2328 test = new 网格图中递增路径的数目2328();
        test.countPaths(new int[][]{{12469,18741,68716,30594,65029,44019,92944,84784,92781,5655,43120,81333,54113,88220,23446,6129,2904,48677,20506,79604,82841,3938,46511,60870,10825,31759,78612,19776,43160,86915,74498,38366,28228,23687,40729,42613,61154,22726,51028,45603,53586,44657,97573,61067,27187,4619,6135,24668,69634,24564,30255,51939,67573,87012,4106,76312,28737,7704,35798}});
//        test.countPaths(new int[][]{{1}, {2}});
//        test.countPaths(new int[][]{{1,1}, {3,4}});
    }
}

//1 1
//3 4



// 1 1
// 2 4
// 1 2 5 4
// 1 2