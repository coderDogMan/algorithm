package writtentest.yongyou2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 最佳面试策略 {
    static int n;
    static int k;
    static LinkedList<int[]>[] list;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        list = new LinkedList[1001];
        for (int i = 0; i < 1001; i++) list[i] = new LinkedList<>();
        memo = new int[1001][k + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int t = in.nextInt();
            int p = in.nextInt();
            list[t].add(new int[]{s, p});
        }
        System.out.println(dfs(1000, k));

    }

    private static int dfs(int end, int k) {
        if (k == 0 || end < 0) return 0;
        if (memo[end][k] != -1) return memo[end][k];
        int res = dfs(end - 1,  k);
        for (int[] node : list[end]) {
            res = Math.max(res, dfs(node[0] - 1, k - 1) + node[1]);
        }
        memo[end][k] = res;
        return res;
    }
}
