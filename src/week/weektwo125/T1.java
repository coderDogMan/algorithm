package week.weektwo125;

import java.util.Arrays;

public class T1 {

    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int i  =0; i < nums.length; i++) if (nums[i] < k) ans++;
        return ans;
    }

}
