package sort.esay;

public class x的平方根69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }
//289398
//2147395600
//2147395600
    public static int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + ( r - l) / 2;
            if ((long)mid * mid < x) {
                l = mid + 1;
            } else if ((long)mid * mid == x) {
                return mid;
            }else {
                r = mid - 1;
            }
        }
        return l < r ? l : r;
    }
}
