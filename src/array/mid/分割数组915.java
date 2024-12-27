package array.mid;

import java.util.LinkedList;

public class 分割数组915 {
    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{1, 1}));
    }

    public static int partitionDisjoint(int[] nums) {
        int lMax = nums[0];
        int res = 0;
        int curMax = nums[0];

        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < lMax) {
                lMax = curMax;
                res = i;
            }
            continue;
        }

        return res + 1;
    }
}
