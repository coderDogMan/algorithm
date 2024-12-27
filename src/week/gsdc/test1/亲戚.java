package week.gsdc.test1;

import java.io.*;

public class 亲戚 {
    static int N = 20010;
    static int[] fa = new int[N];
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) fa[i] = i;
        while (m-- > 0) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            fa[find(a)] = find(b);
        }
        s = in.readLine().trim().split(" ");
        m = Integer.parseInt(s[0]);
        while (m-- > 0) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if (find(a) == find(b)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        out.flush();
    }
    private static int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
}
