package other.mid;

public class 剑指Offer16数值的整数次方 {
    public double myPow(double x, int n) {

        return pow(x, n);
    }

    public double pow(double x, int n) {
        double ans = 1;
        boolean flag = false;
        if (n < 0) {
            n = -n;
            flag = true;
        }
        while (n > 0) {
            if ((n & 1) == 1) ans *= x;
            n >>= 1;
            x *= x;
        }
        if (flag) {
            if (ans < 0) {
                return 0.0;

            }
            ans  = 1 / ans;
        }
        return ans;
    }
}
//class Test {
//    public static void main(String[] args) {
//        剑指Offer16数值的整数次方 test = new 剑指Offer16数值的整数次方();
//        test.myPow(2.00000,-2147483648);
//    }
//}
