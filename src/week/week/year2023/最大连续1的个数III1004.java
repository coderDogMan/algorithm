package week.week.year2023;

public class 最大连续1的个数III1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int cnt = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) cnt++;
            while (cnt > k) {
                if (nums[l++] == 0) cnt--;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
