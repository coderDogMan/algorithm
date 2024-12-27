package week.week.year2024firstQuarter;

public class 分割数组的最大值410 {
    int[] nums;
    public int splitArray(int[] nums, int k) {
        this.nums = nums;
        int l = 0;
        int r = (int) 1e9;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int val, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > val && k > 1) {
                k--;
                sum = 0;
                i--;
            } else if (sum > val && k <= 1) {
                return false;
            }
        }
        return true;
    }
}
