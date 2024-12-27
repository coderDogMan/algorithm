package writtentest.mayi2023;


import java.util.ArrayList;
import java.util.Scanner;

public class 子树 {

    static ArrayList<Integer>[] edge;
    static char[] chars;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        chars = s.toCharArray();
        edge = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            edge[u].add(v);
            edge[v].add(u);
        }
        dfs(1, 0);
        System.out.println(ans);
    }

    private static boolean dfs(int cur, int fa) {
        if (edge[cur].size() == 1 && edge[cur].get(0) == fa) {
            if (chars[cur - 1] == 'R') {
                ans++;
                return true;
            } else {
                return false;
            }
        }
        boolean flag;
        if (chars[cur - 1] == 'R') {
            flag = true;
        } else {
            flag = false;
        }
        for (Integer son : edge[cur]) {
            if (son == fa) continue;
            flag &= dfs(son, cur);
        }
        if (flag) ans++;
        return flag;
    }

}
