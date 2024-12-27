package week.week.year2024firstQuarter;

public class 无限数组的最短子数组2875 {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long mod = 0;
        for (int num : nums) mod += num;
        int add = (int) ((target / mod) * n);
        target %= mod;
        int sum = 0;
        int l = 0;
        int ans = -1;
        for (int i = 0; i < 2 * n; i++) {
            sum += nums[i % n];
            while (l < i && sum > target) sum -= nums[l++ % n];
            if (ans == -1 && sum == target) {
                ans = i - l + 1;
            } else if (sum == target) {
                ans = Math.min(ans, i - l + 1);
            }
        }
        return ans == -1 ? -1 : ans + add;
    }
}
class Test11 {
    public static void main(String[] args) {
        无限数组的最短子数组2875 test = new 无限数组的最短子数组2875();
        test.minSizeSubarray(new int[]{5,5,4,1,2,2,2,3,2,4,2,5}, 56);
//        test.minSizeSubarray(new int[]{1,1,1,2,3}, 4);
    }
}
