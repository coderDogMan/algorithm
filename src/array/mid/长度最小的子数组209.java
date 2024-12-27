package array.mid;

public class 长度最小的子数组209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                len = Math.min(len, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
