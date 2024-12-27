package writtentest.mt2023;

import java.util.Scanner;

public class 交通规划 {
    static int N = 10010;
    static int[] faL = new int[N];
    static int[] faR = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        for (int i  = 1; i <= n; i++) {
            faL[i] = i;
            faR[i] = i;
        }
        while (t-- > 0) {
            String op = in.next();
            int x = in.nextInt();
//            if (x == 1 || x == n) continue;
            if (op.equals("Q")) {
                int l = find(x, faL);
                int r = find(x, faR);
                System.out.println(l + " " + r);
            } else if (op.equals("L") && x > 1) {
                if (x == faL[x]) {
                    faL[x] = x - 1;
                    faR[x - 1] = x;
                }
            } else if (op.equals("R") && x < n) {
                if (x == faR[x]) {
                    faR[x] = x + 1;
                    faL[x + 1] = x;
                }
            }
        }
    }
    private static int find(int x, int[] fa) {
        if (x != fa[x]) fa[x] = find(fa[x], fa);
        return fa[x];
    }
}
