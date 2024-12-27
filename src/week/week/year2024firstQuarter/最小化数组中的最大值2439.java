package week.week.year2024firstQuarter;

public class 最小化数组中的最大值2439 {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long max = nums[0];
        long sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, (sum + i) / (i + 1));
        }
        return (int) max;
    }
}
