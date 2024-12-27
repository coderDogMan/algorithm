package other.mid;

public class 最大子数组和53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res > 0) {
                res += nums[i];
                max = Math.max(max, res);
            } else {
                res = nums[i];
                max = Math.max(max, res);
            }
        }
        return res;
    }
}
