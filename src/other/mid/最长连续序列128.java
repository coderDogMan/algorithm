package other.mid;

import week.weektwo98.修改两个元素的最小分数6361;

import java.util.HashMap;
import java.util.HashSet;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] - 1;
            int max = 1;
            if (map.containsKey(num)) {
                map.put(num, map.get(num + 1) + 1);
                max = map.get(num + 1) + 1;
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}

