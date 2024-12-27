package week.week338;

public class T1 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;
        if (k >= numOnes) {
            ans += numOnes;
            k -= numOnes;
        } else if (k > 0) {
            ans = k;
            numOnes = numOnes - k;
            k = 0;
        }
        if (k >= numZeros) {
            k -= numZeros;
        } else if (k > 0) {
            numZeros = numZeros - k;
            k = 0;
        }
        if (k >= numNegOnes) {
            ans -= numNegOnes;
        } else if (k > 0) {
            ans -= k;
        }
        return ans;
    }
}
class Test {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.kItemsWithMaximumSum(3,2,0,2);
    }
}
