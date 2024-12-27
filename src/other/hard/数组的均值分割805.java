package other.hard;

public class 数组的均值分割805 {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        int size = sum / 2;
        int[] dp = new int[size + 1];
        for (int i = 0; i < n; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[size] == size;
    }
}

class Test4 {
    public static void main(String[] args) {
        数组的均值分割805 test = new 数组的均值分割805();
        test.splitArraySameAverage(new int[]{6,8,18,3,1});
    }
}
