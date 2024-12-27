package week.weektwo121;

import java.util.Arrays;

public class T4 {

    int limit;
    char[] st;
    char[] fi;
    char[] s;
    long[] memo;
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.s = s.toCharArray();
        this.limit = limit;
        String st = String.valueOf(start);
        for (int i = 0; i < String.valueOf(finish).length() - String.valueOf(start).length(); i++) st = "0" + st;
        fi = String.valueOf(finish).toCharArray();
        this.st = st.toCharArray();
        memo = new long[fi.length];
        Arrays.fill(memo, -1);
        return dfs(0, true, true);
    }



    private long dfs(int i, boolean HLimit, boolean LLimit) {
        if (i == fi.length) {
            return 1;
        }
        if (!HLimit && !LLimit && memo[i] != -1) return memo[i];
        int hi = HLimit ? fi[i] - '0' : 9;
        int lo = LLimit ? st[i] - '0' : 0;

        long res = 0;
        if (i < fi.length - s.length) {
            for (int d = lo; d <= Math.min(hi, limit); d++) {
                res += dfs(i + 1, HLimit && d == hi, LLimit && d == lo);
            }
        } else {
            int x = s[i - (fi.length - s.length)] - '0';
            if (lo <= x && x <= hi) {
                res += res += dfs(i + 1, HLimit && x == hi, LLimit && x == lo);
            }
        }
        if (!HLimit && !LLimit && memo[i] != -1)  memo[i] = res;
        return res;
    }

}

class Test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.numberOfPowerfulInt(1, 6000, 4, "124");
    }
}