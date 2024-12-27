package week.week.year2023;

public class 统计得分小于K的子数组数目2302 {

    long k = 0;
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        this.k = k;
//        int MOD = (int) 1e9 + 7;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++)
            preSum[i] = nums[i - 1] + preSum[i - 1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int l = check(preSum, i);
            ans += (i - l);
        }
        return ans;
    }
    // 找到以i为右端点的l
    private int check(long[] preSum, int i) {
        int l = 0;
        int r = i - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((i - mid) * (preSum[i] - preSum[mid]) < k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

class Test66 {
    public static void main(String[] args) {
        统计得分小于K的子数组数目2302 test = new 统计得分小于K的子数组数目2302();
        test.countSubarrays(new int[]{2,1,4,3,5}, 10);
    }

}
