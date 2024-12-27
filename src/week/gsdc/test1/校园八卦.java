package week.gsdc.test1;

import java.io.*;

public class 校园八卦 {
    static int N = (int) 5e5 + 10;
    static int[] fa = new int[N];
    static int[] val = new int[N];
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
            val[i] = 1;
        }
        while (m-- > 0) {
            s = in.readLine().split(" ");
            int size = Integer.parseInt(s[0]);
            if (size == 0) continue;
            int x = Integer.parseInt(s[1]);
            for (int i = 1; i < size; i++) {
                int v = Integer.parseInt(s[i + 1]);
                merge(x, v);
            }
        }

        for (int i = 1; i <= n; i++) {
            out.print(val[find(i)] + " ");
        }
        out.flush();
    }

    private static void merge(int u, int v) {
        int fu = find(u);
        int fv = find(v);
        if (fu != fv) {
            fa[fv] = fu;
            val[fu] += val[fv];
        }
    }

    private static int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
}
