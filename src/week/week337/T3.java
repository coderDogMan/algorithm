package week.week337;

public class T3 {
    public int beautifulSubsets(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < n; p++) {
                for (int j = i - p; j < n; j++) {
                    if (Math.abs(nums[i] - nums[j]) != k) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
