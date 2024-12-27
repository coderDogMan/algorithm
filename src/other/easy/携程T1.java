package other.easy;

class T1 {
    public int getLen(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}


public class 携程T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.getLen(new int[]{2, 4, 2, 3, 2}));
        System.out.println(t1.getLen(new int[]{2, 4}));
        System.out.println(t1.getLen(new int[]{2, 4, 3}));
        System.out.println(t1.getLen(new int[]{2, 4, 1, 2, 3, 4, 5, 6}));
    }
}
