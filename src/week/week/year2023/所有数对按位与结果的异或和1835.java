package week.week.year2023;

public class 所有数对按位与结果的异或和1835 {
    public int getXORSum(int[] arr1, int[] arr2) {
        int sum2 = 0;

        for (int i : arr2) {
            sum2 ^= i;
        }
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            ans ^= (arr1[i] & sum2);

        }
        return ans;
    }
}

class Test80 {
    public static void main(String[] args) {
        所有数对按位与结果的异或和1835 test = new 所有数对按位与结果的异或和1835();
        test.getXORSum(new int[]{1033,4179,1931,8117,7364,7737,6219,3439,1537,7993}, new int[]{6386});
    }
}