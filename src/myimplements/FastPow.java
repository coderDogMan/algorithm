package myimplements;

public class FastPow {
    public int pow (int x, int y) {
        int ans = 1;
        while (y > 0) {
            if ((y & 1) == 1) ans *= x;
            y >>= 1;
            x *= x;
        }
        return ans;
    }
}

//class Test {
//    public static void main(String[] args) {
//        FastPow fastPow = new FastPow();
//        System.out.println(fastPow.pow(2,3));
//    }
//}