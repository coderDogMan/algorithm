package week.week.year2023;

public class 最大异或乘积2939 {
    public static int MOD = (int) 1e9 + 7;
    public int maximumXorProduct(long a, long b, int n) {
        if (b > a) {
            long temp = b;
            b = a;
            a = temp;
        }
        long mask = (1L << n) - 1;
        long al = a & ~mask;
        long bl = b & ~mask;
        a &= mask;
        b &= mask;
        long left = a ^ b;
        long one = mask ^ left;
        al |= one;
        bl |= one;
        if (al == bl) {
            long heightBit = 1L << (63 - Long.numberOfLeadingZeros(left));
            al |= heightBit;
            left ^= heightBit;
        }
        bl |= left;
        return (int) (al * bl % MOD);
    }

}

class Test87 {
    public static void main(String[] args) {
        最大异或乘积2939 test = new 最大异或乘积2939();
        System.out.println(test.maximumXorProduct(12, 5, 4));
        System.out.println(test.maximumXorProduct(0, 7, 2));
    }
}