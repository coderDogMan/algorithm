package week.week.year2023;

public class 区间子数组个数795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i1 = -1, i0 = -1, ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) i0 = i;
            if (nums[i] >= left) i1 = i;
            ans += i1 - i0;
        }
        return ans;
    }
}

class Test68 {
    public static void main(String[] args) {
        区间子数组个数795 test = new 区间子数组个数795();
//        test.numSubarrayBoundedMax(new int[]{2,9,2,5,6}, 2, 8);
        test.numSubarrayBoundedMax(new int[]{2,1,4,3}, 2, 3);
    }
}