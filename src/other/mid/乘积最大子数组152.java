package other.mid;

public class 乘积最大子数组152 {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            ans = Math.max(ans, max);
        }

        return ans;
    }
}
