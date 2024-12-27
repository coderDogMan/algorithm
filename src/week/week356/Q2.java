package week.week356;

import java.util.HashMap;

public class Q2 {


    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            while (map1.size() == map.size()) {
                ans += nums.length - i;
                if (map1.get(nums[l]) == 1) {
                    map1.remove(nums[l]);
                } else {
                    map1.put(nums[l], map1.get(nums[l]) - 1);
                }
                l++;
            }
        }
        return ans;

    }
}
