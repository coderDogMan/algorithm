package week.week337;

public class T1 {
    public int[] evenOddBit(int n) {
        int index = 0;
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n >>= 1 ;
        }
        return new int[]{even, odd};
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
//        System.out.println(t1.evenOddBit(17));
//        System.out.println(t1.evenOddBit(2));
        System.out.println(t1.evenOddBit(1000));
    }
}