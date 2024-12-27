package week.week391;

public class T3 {

    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n];
        sum[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) sum[i] = sum[i - 1] + 1;
            else sum[i] = 1;
        }
        long ans = 0;
        for (long l : sum) {
            ans += l;
        }
        return ans;

    }
}
