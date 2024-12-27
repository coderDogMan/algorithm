package week.week348;

public class C {
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        int r = 0;
        int c = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int op = queries[i][0];
            int idx = queries[i][1];
            int val = queries[i][2];
            if (!row[idx] && op == 0) {
                row[idx] = true;
                ans += (n - c) * val;
                r++;
            } else if (!col[idx] && op == 1){
                col[idx] = true;
                ans += (n - r) * val;
                c++;
            }
        }
        return ans;
    }
}

class Test1 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.matrixSumQueries(3, new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}}));
    }

}