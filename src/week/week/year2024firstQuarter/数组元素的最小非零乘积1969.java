package week.week.year2024firstQuarter;

public class 数组元素的最小非零乘积1969 {

    long MOD = (int) 1e9 + 7;
    public int minNonZeroProduct(int p) {
        long k = pow(2, p) - 1;
        return (int) ((k) % MOD * pow(k - 1, (k - 1) / 2) % MOD);
    }

    public long pow(long a, long b) {
        a = a % MOD;
        b = b % MOD;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            b >>= 1;
            a = a * a % MOD;
        }
        return res;
    }
}
