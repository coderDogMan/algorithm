package week.week.year2024firstQuarter;

public class 查找大小为M的最新分组1562 {

    int[] fa;
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        fa = new int[n + 2];
        for (int i = 0; i <= n + 1; i++) fa[i] = i;
        int[] sum = new int[n + 2];
        int ans = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int to = find(x + 1);
            if (sum[to] == m) cnt--;
            fa[x] = to;
            sum[to] += sum[x] + 1;
            if (sum[x] == m) cnt--;
            if (sum[to] == m) cnt++;
            if (cnt > 0) ans = i + 1;
        }
        return ans;

    }

    private int find(int x) {
        if (x != fa[x]) fa[x] = find(fa[x]);
        return fa[x];
    }
}

class Test14 {
    public static void main(String[] args) {
        查找大小为M的最新分组1562 test = new 查找大小为M的最新分组1562();
        test.findLatestStep(new int[] {3,5,1,2,4}, 1);
    }
}
