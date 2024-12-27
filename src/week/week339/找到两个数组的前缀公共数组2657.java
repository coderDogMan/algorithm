package week.week339;

public class 找到两个数组的前缀公共数组2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long a = 1;
        long b = 1;
        for (int i = 0; i < n; i++) {
            a |= 1 << A[i];
            b |= 1 << B[i];
            ans[i] = Long.bitCount(a & b);
        }
        return ans;
    }
}
