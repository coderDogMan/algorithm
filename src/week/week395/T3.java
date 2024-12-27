package week.week395;

public class T3 {

    public long minEnd(int n, int x) {
        long bit = -1L ^ x;
        long bn = n - 1;
        long ans = x;
        for (int i = 0; i < 64; i++) {
            if (((bit >> i) & 1) == 1) {
                ans |= (bn & 1) << i;
                bn >>= 1;
            }
        }
        return ans;
    }

}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.minEnd(2, 7);
    }
}