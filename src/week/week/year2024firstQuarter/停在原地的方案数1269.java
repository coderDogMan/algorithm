package week.week.year2024firstQuarter;

public class 停在原地的方案数1269 {
    public int numWays(int steps, int arrLen) {
        long[] f = new long[steps];
        int mod = (int) 1e9 + 7;
        f[0] = 1;
        for (int i = 1; i <= steps; i++) {
            long[] temp = f.clone();
            for (int j = 0; j <= Math.min(i, steps); j++) {
                f[j] = (temp[j] + (j > 0 ? temp[j - 1] : 0) + (j + 1 < arrLen ? temp[j + 1] : 0)) % mod;
            }
        }
        return (int) f[0];
    }
}

class Test21 {
    public static void main(String[] args) {
        停在原地的方案数1269 test = new 停在原地的方案数1269();
        test.numWays(3, 2);
    }
}
