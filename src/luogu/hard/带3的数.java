package luogu.hard;

import java.util.Scanner;

public class 带3的数 {
    static int N = 15;
    static long[] f = new long[N];
    static long[] temp = new long[N];
    static int[] A = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        init();
        System.out.println(hanldle(r) - hanldle(l - 1));;
    }

    private static long hanldle(int num) {
        int idx = 0;
        while (num > 0) {
            A[idx++] = num % 10;
            num /= 10;
        }

        return dfs(idx - 1, true);
    }

    private static long dfs(int p, boolean isLimit) {
        if (p < 0) {
            return 0;
        }
        long ans = 0;
        if (!isLimit && temp[p] != -1) return temp[p];
        int up = isLimit ? A[p] : 9;
        for (int i = 0; i <= up; i++) {
            if (i == 3) {
                if (isLimit && i == up) {
                    ans++;
                    for (int j = p - 1; j >= 0; j--) ans += A[j] * f[j];
                } else {
                    ans += f[p];
                }
            }
            else ans += dfs(p - 1, isLimit && i == up);
        }
        if (!isLimit) temp[p] = ans;
        return ans;
    }


    private static void init() {
        f[0] = 1;
        temp[0] = -1;
        for (int i = 1; i < N; i++) {
            f[i] = f[i - 1] * 10;
            temp[i] = -1;
        }
    }
}
