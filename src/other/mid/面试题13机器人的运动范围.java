package other.mid;

import java.util.HashMap;

public class 面试题13机器人的运动范围 {
    int m;
    int n;
    boolean vis[][];
    int ans;
    int k;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        vis = new boolean[m][n];
        dfs(0,0);
        return ans;
    }

    public void dfs(int row, int col) {
        if (row >= m || row < 0 || col >= n || col < 0 || vis[row][col] || getSum(row, col) > k) return;
         ans++;
        vis[row][col] = true;
        //上
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);

    }

    public int getSum(int row, int col) {
        int ans = 0;
        while (row > 0) {
            ans += (row % 10);
            row /= 10;
        }
        while (col > 0) {
            ans += (col % 10);
            col /= 10;
        }
        return ans;
    }
}

class Test5 {
    public static void main(String[] args) {
        面试题13机器人的运动范围 test = new 面试题13机器人的运动范围();
        test.movingCount(7,2,3);
    }
}
