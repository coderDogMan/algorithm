package array.mid;

import java.util.Arrays;

public class 子数组的最小值之和907 {
    public static void main(String[] args) {
        sumSubarrayMins(new int[]{3,1,2,4});
    }

    public static int sumSubarrayMins(int[] A) {
        long res = 0;
        long mod = 1000000007;
        for (int i = 0; i<A.length; i++) {
            int l = i-1;
            for (; l>=0 && A[i] < A[l]; l--) ;
            int r = i+1;
            for (; r<A.length && A[i] <= A[r]; r++) ;

            res += (i-l)*(r-i)*A[i];
        }
        return (int)(res % mod);
    }
}
