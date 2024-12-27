package week.week.year2023;

import java.util.Arrays;

public class 不相交的线1035 {
    int[] nums1;
    int[] nums2;
    int[][] memo;
    int n;
    int m;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        memo = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i == n || j == m) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = 0;
        if (nums1[i] != nums2[j]) {
            res = Math.max(dfs(i + 1, j), dfs(i, j + 1));
        } else {
            res = dfs(i + 1, j + 1) + 1;
        }
        memo[i][j] = res;
        return res;
    }
}

class Test63 {
    public static void main(String[] args) {
        不相交的线1035 test = new 不相交的线1035();
        test.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2});

    }
}