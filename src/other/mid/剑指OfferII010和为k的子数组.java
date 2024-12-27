package other.mid;

import java.util.HashMap;

public class 剑指OfferII010和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
class Test11 {
    public static void main(String[] args) {
        剑指OfferII010和为k的子数组 test = new 剑指OfferII010和为k的子数组();
        test.subarraySum(new int[]{1,1,1}, 2);
    }
}
