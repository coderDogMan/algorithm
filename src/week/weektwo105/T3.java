package week.weektwo105;

import java.util.Arrays;

public class T3 {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        long ans = nums[0];
        long max = nums[0];
        long min = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            long temp = max;
            max = max(max, nums[i], max * nums[i], min * nums[i]);
            min = max(min, nums[i], min * nums[i], temp * nums[i]);
        }
        return Math.max(ans, max);
    }
    public long max(long val1, long val2, long val3, long val4) {
        return Math.max(Math.max(val1, val2), Math.max(val3, val4));
    }
    public long min(long val1, long val2, long val3, long val4) {
        return Math.min(Math.min(val1, val2), Math.min(val3, val4));
    }


}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.maxStrength(new int[]{-5,5,-3,-7,-1,-5,5,1,-8});
//        t3.maxStrength(new int[]{9,6,3});
//        t3.maxStrength(new int[]{0,-1});
        t3.maxStrength(new int[]{3,-1,-5,2,5,-9});
//        t3.maxStrength(new int[]{-4,-5,-4});
    }
}
