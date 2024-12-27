package week.week348;

public class B {

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > nums[i]) {
                minIdx = i;
                min = nums[i];
            }
            if (max < nums[i]) {
                maxIdx = i;
                max = nums[i];
            }
        }
        if (maxIdx < minIdx) {
            return minIdx + (n - maxIdx - 1) - 1;
        }
        return minIdx + (n - maxIdx - 1);
    }
}
