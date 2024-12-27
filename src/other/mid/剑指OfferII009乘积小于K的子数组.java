package other.mid;

import java.util.HashMap;

public class 剑指OfferII009乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans += map.getOrDefault(k - sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;

    }
}

class Test10 {
    public static void main(String[] args) {
        剑指OfferII009乘积小于K的子数组 test = new 剑指OfferII009乘积小于K的子数组();
        test.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
        test.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
    }
}