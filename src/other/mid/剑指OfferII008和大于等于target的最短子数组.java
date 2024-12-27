package other.mid;

public class 剑指OfferII008和大于等于target的最短子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += nums[i];
            while (max >= target) {
                ans = Math.min(ans, i - left + 1);
                left++;
                max -= nums[left];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

class Test9 {
    public static void main(String[] args) {
        剑指OfferII008和大于等于target的最短子数组 test = new 剑指OfferII008和大于等于target的最短子数组();
        test.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
