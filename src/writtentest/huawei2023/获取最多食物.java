package writtentest.huawei2023;

import java.util.ArrayList;
import java.util.Scanner;

public class 获取最多食物 {
    static ArrayList<Integer>[] edge;
    static int[] dit;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edge = new ArrayList[n + 2];
        dit = new int[n + 1];
        for (int i =0; i < n + 2; i++)
            edge[i] = new ArrayList();
        for (int i = 0; i < n; i++) {
            int cur = in.nextInt() + 1;
            int fa = in.nextInt() + 1;
            dit[cur] = in.nextInt();
            edge[cur].add(fa);
            edge[fa].add(cur);
        }
        dit[0] = Integer.MIN_VALUE;
        dfs(0, -1, dit[0]);
        System.out.println(ans);
    }

    private static void dfs(int cur, int fa, int sum) {
        int val;
        if (sum < 0) {
            val = dit[cur];
        } else {
            val = dit[cur] + sum;
        }
        ans = Math.max(ans, val);
        for (Integer son : edge[cur]) {
            if (son == fa) continue;
            dfs(son, cur, val);
        }
    }
}
//0 1 -2
//1 -1 -2
//2 1 -1
//4 0 -2
//5 4 -5
//3 0 -3
//6 2 -3