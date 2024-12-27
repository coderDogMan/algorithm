package week.week339;

public class 使子数组元素和相等2607 {
    public long makeSubKSumEqual(int[] arr, int k) {
        long ans = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i] + " " + arr[(i + k) % n]);
            ans += Math.abs(arr[i] - arr[(i + k) % n]);
        }
        return ans;
    }
}
class Test4 {
    public static void main(String[] args) {
        使子数组元素和相等2607 test = new 使子数组元素和相等2607();
        test.makeSubKSumEqual(new int[]{2,5,5,7}, 3);
//        test.makeSubKSumEqual(new int[]{1,4,1,3}, 2);
    }
}
