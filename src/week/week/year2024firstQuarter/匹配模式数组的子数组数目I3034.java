package week.week.year2024firstQuarter;

public class 匹配模式数组的子数组数目I3034 {

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int ans = 0;
        for (int i = 1; i < n - m  + 1; i++) {
            int idx = i;
            while (idx - i < m && idx < n && (pattern[idx - i] == 1 && nums[idx] - nums[idx - 1] > 0 ||
                    pattern[idx - i] == 0 && nums[idx] - nums[idx - 1] == 0 ||
                    pattern[idx - i] == -1 && nums[idx] - nums[idx - 1] < 0)) {
                idx++;
            }
            if (idx - i == m) ans++;
        }
        return ans;
    }

}

class Test {
    public static void main(String[] args) {
        匹配模式数组的子数组数目I3034 test = new 匹配模式数组的子数组数目I3034();
        test.countMatchingSubarrays(new int[]{1,2,3,4,5,6}, new int[]{1,1});
    }
}
