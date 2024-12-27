package week.weektwo91;

public class 统计构造好字符串的方案数6238 {
    public static void main(String[] args) {
        int i = countGoodStrings(2, 3, 1, 2);
        System.out.println(i);
    }
    public final static int MOD = 1000000007;

    public static int countGoodStrings(int low, int high, int zero, int one) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            res += getNum(i, zero, one);


        }
        return res;
    }

    private static int getNum(int i, int zero, int one) {
              //x个zero
              //y个one
        int res = 0;
        for(int x = 0; x <= i; x++) {
            for(int y = 0; y <= i; y++) {
                if ((x * zero + y * one) == i)
                    res++;
            }
        }
        for(int y = 0; y <= i; y++) {
            for(int x = 0; x <= i; x++) {
                if ((x * zero + y * one) == i)
                    res++;
            }
        }




        return res % MOD;
    }
}
