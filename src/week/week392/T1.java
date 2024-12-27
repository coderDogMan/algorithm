package week.week392;

public class T1 {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int ce = 1, de = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                de++;
                ce = 1;
                ans = Math.max(ans, de);
            } else if (nums[i] > nums[i - 1]) {
                ce++;
                de = 1;
                ans = Math.max(ans, ce);
            } else {
                ce = 1;
                de = 1;
            }
        }
        return ans;

    }
}
