package niuke.week.Round34;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class T5 {

    static char[] value;
    static  LinkedList<Integer>[] g;
    public static void main(String[] args) {
        // 0 d    1 p    2 ?
//        char[] map = new char[]{'d', 'p', '?'};
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        value = new char[n + 1];
        g = new LinkedList[n + 1];
        Arrays.setAll(g, e -> new LinkedList<>());
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        int i = 0;
        while (i < n && s.charAt(i) == '?') i++;
        if (i == n) {
            value[1] = 'd';
            dfs(-1,1, 'd');
            for (int j = 1; j <= n; j++) {
                System.out.print(value[j] + " ");
            }
            return;
        } else {
            value[i + 1] = s.charAt(i);
            dfs(-1, i + 1, s.charAt(i));
            for (int j = 0; j < n; j++) {
                if ((value[j + 1] == 'p' && s.charAt(j) == 'd') || value[j + 1] == 'd' && s.charAt(j) == 'p') {
                    System.out.println(-1);
                    return;
                }
            }
            for (int j = 1; j <= n; j++) {
                System.out.print(value[j] + " ");
            }
        }

    }

    private static void dfs(int fa, int cur, char val) {
        if (g[cur].size() == 1 && g[cur].getLast() == fa) {
            return;
        }
        for (Integer son : g[cur]) {
            if (son == fa) continue;
            if (val == 'd') {
                value[son] = 'p';
                dfs(cur, son, 'p');
            } else {
                value[son] = 'd';
                dfs(cur, son, 'd');
            }

        }

    }

}
