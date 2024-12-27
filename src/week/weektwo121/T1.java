package week.weektwo121;

import java.util.HashSet;

public class T1 {

    public int missingInteger(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int sum = nums[0];
        set.add(nums[0]);
        int i = 1;
        while (i < n && nums[i] - 1 == nums[i - 1]) {
            set.add(nums[i]);
            sum += nums[i];
            i++;
        }
        for (; i < n; i++) {
            set.add(nums[i]);
        }
        while (set.contains(sum)) {
            sum++;
        }
        return sum;
    }

}
