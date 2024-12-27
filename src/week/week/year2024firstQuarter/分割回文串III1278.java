package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 分割回文串III1278 {
    String s;
    public int palindromePartition(String s, int k) {
        int n = s.length();
        this.s = s;
        int[][] f = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        for (int i = 1; i <= Math.min(n, k); i++) f[i][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1) {
                    f[i][1] = get(0, i - 1);
                } else {
                    for (int l = 1; l <= i - j; l++) {
                        f[i][j] = Math.min(f[i][j], f[i - l][j - 1] + get(i - l, i - 1));
                    }
                }
            }
        }
        return f[n][k];
    }

    private int get(int l, int r) {
        int res = 0;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) res++;
        }
        return res;
    }
}

class Test12 {
    public static void main(String[] args) {
        分割回文串III1278 test = new 分割回文串III1278();
        test.palindromePartition("abc", 2);
    }
}