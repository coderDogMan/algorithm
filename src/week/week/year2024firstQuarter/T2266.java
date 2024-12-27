package week.week.year2024firstQuarter;

public class T2266 {
    static int MOD = (int) 1e9 + 7;
    static int N = (int) 1e5 + 1;
    static int[] f = new int[N];
    static int[] g = new int[N];
     static {
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        f[4] = g[4] = 7;
        for (int i = 5; i < N; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
            g[i] = g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4];
        }
    }

    public int countTexts(String s) {
        int n = s.length();
        int l = 0;
        long ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = i - l;
            if (s.charAt(i) != s.charAt(l)) {
                if (s.charAt(l) != '7' && s.charAt(l) != '9')
                    ans = (ans * f[cnt]) % MOD;
                else ans = (ans * g[cnt]) % MOD;
                l = i;
            }
            if (i == n - 1) {
                if (s.charAt(l) != '7' && s.charAt(l) != '9')
                    ans = (ans * f[cnt + 1]) % MOD;
                else ans = (ans * g[cnt] + 1) % MOD;
            }
        }
        return (int) ans;
    }

}

class Test37 {
    public static void main(String[] args) {
        T2266 test = new T2266();
        test.countTexts("22233");
    }
}
