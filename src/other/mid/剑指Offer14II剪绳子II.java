package other.mid;

public class 剑指Offer14II剪绳子II {
    int mod = 1000000007;
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int m = n % 3;
        int y = n / 3;
        long ans = 0;
        if (m == 0) {
            ans = pow(3, y);
        } else if (m == 1) {
            ans = pow(3, y - 1) * 4;
        } else {
            ans = pow(3, y) * 2;
        }
        return (int)(ans % mod);
    }

    public long pow(long x, int y) {
        long ans = 1;
        while (y > 0) {
            if ((y & 1) == 1) ans = x * ans % mod;
            y >>= 1;
            x = x * x % mod;
        }
        return ans;
    }
}

/*
class Test {
    public static void main(String[] args) {
        剑指Offer14II剪绳子II test = new 剑指Offer14II剪绳子II();
        System.out.println(test.cuttingRope(120));

    }
}*/
