package other.mid;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 最短无序连续子数组581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int right = 0;
        int left = 0;
        int leftMax = nums[0];
        for (int i = 1; i < n; i++) {
            if (leftMax <= nums[i]) {
                leftMax = nums[i];
            } else {
                right = i;
            }
        }
        int rigthMin = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (rigthMin >= nums[i]) {
                rigthMin = nums[i];
            } else {
                left = i;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,1);
        map.put(4,1);

        return right == left ? 0 : right - left + 1;
    }
}
