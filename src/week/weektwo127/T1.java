package week.weektwo127;

public class T1 {

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int[][] prefix = new int[n + 1][31];
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j < 31; j++) {
                prefix[i][j] = prefix[i - 1][j] + (x & 1);
                x >>= 1;
            }
        }
        int l = 0, ans = Integer.MAX_VALUE, sum = 0;
        if (sum >= k) ans = 1;
        for (int i = 0; i < n; i++) {
            sum |= nums[i];
            while (l <= i && sum >= k) {
                ans = Math.min(ans, i - l + 1);
                int x = 1;
                int curSum = 0;
                for (int j = 0; j < 31; j++) {
                    if (prefix[i + 1][j] - prefix[l + 1][j] > 0) curSum |= x;
                    x <<= 1;
                }
                sum = curSum;
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.minimumSubarrayLength(new int[]{1,2}, 0);
//        t1.minimumSubarrayLength(new int[]{2,1,8}, 10);
//        t1.minimumSubarrayLength(new int[]{1,2,3}, 3);
    }
}