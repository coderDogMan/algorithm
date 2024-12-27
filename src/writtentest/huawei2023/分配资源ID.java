package writtentest.huawei2023;

import java.util.Scanner;

public class 分配资源ID {
    static int N = 100005;
    static int[] L = new int[N];
    static int[] R = new int[N];
    static boolean[] used = new boolean[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int n = r - l + 1;
        int t = in.nextInt();
        for (int i = l; i <= r; i++) {
            L[i] = i - 1;
            R[i] = i + 1;
        }
        int start = l;
        int end = r;

        while (t-- > 0) {
            int op = in.nextInt();
            int val = in.nextInt();
            if (op == 1) {
                if (val > n) continue;
                while (val-- > 0) {
                    R[L[start]] = R[start];
                    L[R[start]] = L[start];
                    n--;
                    used[start] = true;
                    start = R[start];
                }
            } else if (op == 2) {
                if (used[val]) continue;
                R[L[val]] = R[val];
                L[R[val]] = L[val];
                used[start] = true;
                if (val == start) start = R[val];
                else if (val == end) end = L[val];
                n--;
            } else if (op == 3) {
                if (!used[val]) continue;
                if (n == 0) {
                    start = end = val;
                } else {
                    R[end] = val;
                    L[val] = end;
                    end = val;
                }
                used[val] = false;
                n++;
            }
        }
        System.out.println(start);
    }
}
